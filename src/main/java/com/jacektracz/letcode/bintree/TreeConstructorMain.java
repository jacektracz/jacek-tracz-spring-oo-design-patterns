package com.jacektracz.letcode.bintree;

//https://coderbyte.com/solution/Tree%20Constructor#Java
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class TreeConstructorMain {

	public static void exec_main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sOutErr = TreeConstructor(s.nextLine());
		String sOut = "true";
		if (!sOutErr.isEmpty()) {
			sOut = "false";
		}
		System.out.print(sOut);
	}

	public static String TreeConstructor(String strArr) {
		String sErr = TreeNodeCreator.checkConstructionFromStr(strArr);
		return sErr;
	}

	public static String TreeConstructor(String[] strArr) {
		String sErr = TreeNodeCreator.checkConstruction(strArr);
		return sErr;
	}

	public static class TreeNode {
		public String val;
		public Integer data;
		public TreeNode left;
		public TreeNode right;
		public Integer state = 0;
	}

	public static class CtxOper {
		public Map<String, TreeNode> nodes = new HashMap<>();
	}

	public static class TreeNodeCreator {

		public static String checkConstructionFromStr(String strNodes) {
			dbg("Start:" + strNodes,"");
			String strNodesReplaced = strNodes.replace(")(", ")X(");
			String[] nodesArr = strNodesReplaced.split("X");
			return checkConstruction(nodesArr);
		}

		public static String checkConstruction(String[] strNodes) {

			CtxOper ctx = new CtxOper();
			String errorsOnCreation = "";
			errorsOnCreation = createTree(ctx, strNodes);

			String errorsOnCheck = checkResults(ctx, ctx.nodes);
			
			errorsOnCreation = errorsOnCreation + errorsOnCheck;
			
			return errorsOnCreation;
		}

		public static String createTree(CtxOper ctx, String[] nodesArr) {
			String errors = "";
			List<String> nodesList = Arrays.asList(nodesArr);

			for (String node : nodesList) {
				String err = addNode(ctx, node);
				if (!err.isEmpty()) {
					errors = errors + "[" + err + "]";
				}
			}
			return errors;
		}

		public static String checkResults(CtxOper ctx, Map<String, TreeNode> checkedNodes) {
			String errors = "";
			BiFunction<TreeNode,TreeNode, Boolean> comparator = getComparatorLeftIsLower();
			TreeNode root = getRootNode(ctx,comparator);
			dbg("Root:" + root.data, "");
			root.state = 1;
			
			visitNode(root);
			
			errors = checkVisited(ctx);
			
			printNodes(ctx);
			return errors;

		}

		public static String checkVisited(CtxOper ctx) {
			String errors = "";
			
			dbg("CheckVisited start ===>","");
			
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode node = entry.getValue();
				String ni = getNodeStrInfo(node);
				dbg(ni,"");
				
				if (node.state == 0) {
					String err = "[not-visited:" + node.data + "]";
					errors = errors + err;
					dbg(err,"");
				}else {
					dbg("Node visited checked:" + node.data,"");
				}
			}
			dbg(errors,"");
			
			dbg("CheckVisited end <===","");
			
			return errors;
		}
		
		public static String printNodes(CtxOper ctx) {
			String errors = "";
			dbg("PrintNodes start ===>","");
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode node = entry.getValue();
				String ni = getNodeStrInfo(node);
				dbg(ni,"");
			}
			dbg("PrintNodes end <===","");
			return errors;
		}
		
		public static String getNodeStrInfo(TreeNode node) {
			String ni ="";
			ni = ni + "[val:" + node.data +  "]";
			ni = ni + "[state:" + node.state +  "]";
			if(node.left != null) {
				ni = ni + "[left:" + node.left.data +  "]";	
			}
			if(node.right != null) {
				ni = ni + "[right:" + node.right.data +  "]";	
			}		
			return ni;
		}
		
		public static void visitNode(TreeNode node) {
			node.state = 1;
			dbg("Node visited:" + node.data,"");
			if (node.left != null) {
				visitNode(node.left);
			}
			if (node.right != null) {
				visitNode(node.right);
			}
		}

		public static TreeNode getRootNode(CtxOper ctx,BiFunction<TreeNode,TreeNode, Boolean> predicate) {
			TreeNode root = null;
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode currNode =  entry.getValue();
				Boolean isLeft = predicate.apply( currNode, root);
				if (isLeft) {
					root = currNode;					
				}
			}
			return root;
		}
		
		public static BiFunction<TreeNode,TreeNode, Boolean> getComparatorLeftIsLower(){
			BiFunction<TreeNode,TreeNode, Boolean> comparator = (left, right) -> {
					if(left == null) {
						return false;
					}
					if(right == null) {
						return true;
					}				
					return left.data < right.data ;
				};
				
			return comparator;
		}

		public static String addNode(CtxOper ctx, String strNode) {

			String strDebug = "dbg:" + strNode;
			String[] lr = strNode.replace("(", "").replace(")", "").split(",");
			String leftParent = lr[0];
			String rightChild = lr[1];

			TreeNode parent = createOrGetNode(ctx, leftParent);
			String err = addChild(ctx, parent, rightChild, strDebug);
			return err;
		}

		public static String addChild(CtxOper ctx, TreeNode parent, String childVal, String strDebug) {

			if (parent.left != null && parent.right != null) {
				String err = getErrInfo(parent, "left-right-filled:for-node:" + strDebug);
				dbg(err,"");
				return err;
			} else if (parent.left == null && parent.right != null) {
				String err = getErrInfo(parent, "left-null-right-filled:for-node:" + strDebug);
				dbg(err,"");
				return err;
			}

			else if (parent.left == null && parent.right == null) {
				addLeftChild(ctx, parent, childVal);
				return "";
			}

			else if (parent.left != null && parent.right == null) {
				Integer valCurr = Integer.valueOf(childVal);
				Integer valLeft = parent.left.data;
				if (valCurr >= valLeft) {
					addRightChild(ctx, parent, childVal);
				} else {
					parent.right = parent.left;
					addLeftChild(ctx, parent, childVal);
				}
				return "";
			}
			return "";
		}

		public static void addLeftChild(CtxOper ctx, TreeNode parent, String val) {
			TreeNode child = createOrGetNode(ctx, val);
			parent.left = child;
		}

		public static void addRightChild(CtxOper ctx, TreeNode parent, String val) {
			TreeNode child = createOrGetNode(ctx, val);
			parent.right = child;

		}

		public static TreeNode createOrGetNode(CtxOper ctx, String val) {
			TreeNode child = getFromStore(ctx, val);
			if (child == null) {
				child = createNode(ctx, val);
				addToStore(ctx, child);
			}
			return child;
		}

		public static TreeNode createNode(CtxOper ctx, String val) {
			TreeNode child = new TreeNode();
			child.val = val;
			child.data = Integer.valueOf(val);
			return child;
		}

		public static void addToStore(CtxOper ctx, TreeNode node) {
			if (!ctx.nodes.containsKey(node.val)) {
				ctx.nodes.put(node.val, node);
			}
		}

		public static TreeNode getFromStore(CtxOper ctx, String val) {
			TreeNode node = null;
			if (ctx.nodes.containsKey(val)) {
				node = ctx.nodes.get(val);
			}
			return node;

		}

		public static String getErrInfo(TreeNode parent, String strDebug) {
			String err = "";
			err = err + strDebug;
			err = err + "[parent:" + parent.val + "]";
			err = err + "[parent.curr.left:" + parent.left.val + "]";
			err = err + "[parent.curr.right:" + parent.right.val + "]";

			return err;
		}

	}

	static boolean isCompleteBT(TreeNode root) {
		// Base Case: An empty tree is complete Binary Tree
		if (root == null)
			return true;

		// Create an empty queue
		Queue<TreeNode> queue = new LinkedList<>();

		// Create a flag variable which will be set true
		// when a non full node is seen
		boolean flag = false;

		// Do level order traversal using queue.
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp_node = queue.remove();

			/* Check if left child is present */
			if (temp_node.left != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty left child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Left Child
				queue.add(temp_node.left);
			}
			// If this a non-full node, set the flag as true
			else
				flag = true;

			/* Check if right child is present */
			if (temp_node.right != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty right child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Right Child
				queue.add(temp_node.right);

			}
			// If this a non-full node, set the flag as true
			else
				flag = true;
		}
		// If we reach here, then the tree is complete Binary Tree
		return true;
	}

	boolean isBST(TreeNode node) {
		if (node == null)
			return true;

		/* False if left is > than node */
		if (node.left != null && node.left.data > node.data)
			return false;

		/* False if right is < than node */
		if (node.right != null && node.right.data < node.data)
			return false;

		/* False if, recursively, the left or right is not a BST */
		if (!isBST(node.left) || !isBST(node.right))
			return false;

		/* Passing all that, it's a BST */
		return true;
	}
	
	private static void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}		
	
	class CA implements ia, ib{

		@Override
		public void get() {
			// TODO Auto-generated method stub
			ia.super.get();
		}
		
	}
	static interface ia{
		default void get() {
			
		}
	}
	
	static interface ib{
		default void get() {
			
		}
	}
	
}
