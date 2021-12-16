package com.jacektracz.letcode.bintree;

import java.util.ArrayList;
//https://coderbyte.com/solution/Tree%20Constructor#Java
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class TreeReversedConstructorMain {

	public static void exec_main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sOut = TreeConstructor(s.nextLine());
		System.out.print(sOut);
	}

	public static String TreeConstructor(String strArr) {
		String sErr = TreeReversedNodeCreator.checkConstructionFromStr(strArr);
		String sOut = "true";
		if (!sErr.isEmpty()) {
			sOut = "false";
		}		
		return sOut;
	}

	public static String TreeConstructor(String[] strArr) {
		String sErr = TreeReversedNodeCreator.checkConstruction(strArr);
		String sOut = "true";
		if (!sErr.isEmpty()) {
			sOut = "false";
		}		
		return sOut;
	}
	
	public static class TreeNodeProducerInputData{
		public String inputLeft;
		public String inputRight;		
		public Integer inputDataLeft;
		public Integer inputDataRight;
	}	
	
	public static class TreeNodeProducerData{
		
		public Integer computedParent;
		public Integer computedChildValue;
		public Integer computedNodeValue;
		
	}

	public static class TreeNode {
		public String val;
		public Integer data;
		
		public List<TreeNode> parents = new ArrayList<>();
		public List<TreeNode> childs = new ArrayList<>();
		public Integer state = 0;
	}

	public static class CtxOper {
		public Map<String, TreeNode> nodes = new HashMap<>();
		public TreeNodeProducerData producerData = new TreeNodeProducerData();
		public CtxOper(){
			 nodeProducerParentChild = (u) ->{			
					TreeNodeProducerData treeNodeProducerData = new TreeNodeProducerData();
					treeNodeProducerData.computedParent = Integer.valueOf(u.inputDataLeft);
					treeNodeProducerData.computedNodeValue = Integer.valueOf(u.inputDataRight);
					treeNodeProducerData.computedChildValue = Integer.valueOf(u.inputDataRight);
					return treeNodeProducerData;
				};
				nodeProducerChildParent = (u) ->{			
					TreeNodeProducerData treeNodeProducerData = new TreeNodeProducerData();
					treeNodeProducerData.computedParent = Integer.valueOf(u.inputDataRight);
					treeNodeProducerData.computedNodeValue = Integer.valueOf(u.inputDataLeft);
					treeNodeProducerData.computedChildValue = Integer.valueOf(u.inputDataLeft);
					return treeNodeProducerData;
				}; 
				nodeProducer = nodeProducerChildParent; 
		}
		
		public Function<TreeNodeProducerInputData,TreeNodeProducerData> nodeProducer ;		
		public Function<TreeNodeProducerInputData,TreeNodeProducerData> nodeProducerParentChild ;		
		public Function<TreeNodeProducerInputData,TreeNodeProducerData> nodeProducerChildParent ;
		
	}

	public static class TreeReversedNodeCreator {

		public static String checkConstructionFromStr(String strNodes) {
			dbg("Start:" + strNodes,"");
			String strNodesReplaced = strNodes.replace(")(", ")X(");
			String[] nodesArr = strNodesReplaced.split("X");
			return TreeReversedNodeCreator.checkConstruction(nodesArr);
		}

		public static String checkConstruction(String[] strNodes) {

			CtxOper ctx = new CtxOper();
			
			createTree(ctx, strNodes);
			dbg("input:start","");
			printInput(strNodes);
			dbg("input:end","");
			
			dbg("nodes:start","");
			printNodes(ctx);
			dbg("nodes:end","");
			
			
			Function<TreeNode, Boolean> comparator = getComparatorParentsIsNull();
			List<TreeNode> roots = getRootNodes(ctx,comparator);
			
			dbg("roots:start","");
			printNodes(roots);
			dbg("(roots):" + roots.size(),"");
			dbg("roots:end","");
			
			String errorsOnCheck = "";
			if(roots.size()!= 1) {
				errorsOnCheck = errorsOnCheck + "(roots):" + roots.size();
			}
						
			Function<TreeNode, Boolean> comparatorUnproperChilds = getComparatorUnproperChilds();
			List<TreeNode> unproperChilds = getUnproperChildNodes(ctx,comparatorUnproperChilds);
			
			dbg("unproperChilds::start","");
			printNodes(unproperChilds);
			dbg("(unproperChilds):" + unproperChilds.size(),"");
			dbg("unproperChilds::end","");
			
			if(unproperChilds.size()!= 0) {
				errorsOnCheck = errorsOnCheck + "(unproperChilds):" + unproperChilds.size();
			}
			
			dbg("(output-err:[" + errorsOnCheck + "])","");
			return errorsOnCheck;
		}

		public static void printInput(String[] strNodes) {
			Arrays.asList(strNodes).parallelStream().forEach(u -> dbg(u,""));
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

		public static String checkResultsByVisiting(CtxOper ctx, Map<String, TreeNode> checkedNodes) {
			String errors = "";
			Function<TreeNode, Boolean> comparator = getComparatorParentsIsNull();
			TreeNode root = getRootNode(ctx,comparator);
			dbg("Root:" + root.data, "");
			root.state = 1;
			
			visitNode(root);
			
			errors = checkVisited(ctx);
						
			return errors;

		}
		
		public static String checkParents(CtxOper ctx) {
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
				printNode(entry.getValue());
			}
			dbg("PrintNodes end <===","");
			return errors;
		}
		
		
		public static String printNodes(List<TreeNode> nodes) {
			String errors = "";
			dbg("PrintNodes start ===>","");
			for (TreeNode entry : nodes) {
				printNode(entry);
			}
			dbg("PrintNodes end <===","");
			return errors;
		}
		
		private static void printNode(TreeNode node) {			
			String ni = getNodeStrInfo(node);
			dbg(ni,"");			
		}
		
		public static String getNodeStrInfo(TreeNode node) {
			String ni ="";
			ni = ni + "[val:" + node.data +  "]";
			
			for(TreeNode parent:node.parents) {				
				ni = ni + "[parent:" + parent.data +  "]";	
			}
			ni = ni + "[state:" + node.state +  "]";
			
			for(TreeNode child:node.childs) {				
					ni = ni + "[child:" + child.data +  "]";	
			}
			return ni;
		}
		
		public static void visitNode(TreeNode node) {
			node.state = node.state + 1;
			dbg("Node visited:" + node.data,"");
			for(TreeNode child: node.childs) {
				if(child.state == 0) {
					visitNode(child);		
				}
			}	
			for(TreeNode parent: node.parents) {
				visitNode(parent);
			}
		}

		public static TreeNode getRootNode(CtxOper ctx,Function<TreeNode, Boolean> predicate) {
			TreeNode root = null;
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode currNode =  entry.getValue();
				Boolean isLeft = predicate.apply( currNode);
				if (isLeft) {
					root = currNode;					
				}
			}
			return root;
		}
		
		public static List<TreeNode> getRootNodes(CtxOper ctx,Function<TreeNode, Boolean> predicate) {
			List<TreeNode> roots = new ArrayList<>();;
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode currNode =  entry.getValue();
				Boolean isLeft = predicate.apply( currNode);
				if (isLeft) {
					roots.add(currNode);					
				}
			}
			return roots;
		}
		
		public static List<TreeNode> getUnproperChildNodes(CtxOper ctx,Function<TreeNode, Boolean> predicate) {
			List<TreeNode> roots = new ArrayList<>();;
			for (Map.Entry<String, TreeNode> entry : ctx.nodes.entrySet()) {
				TreeNode currNode =  entry.getValue();
				Boolean isLeft = predicate.apply( currNode);
				if (isLeft) {
					roots.add(currNode);					
				}
			}
			return roots;
		}
		
		public static Function<TreeNode, Boolean> getComparatorParentsIsNull(){
			Function<TreeNode, Boolean> comparator = (left) -> {
					return left.parents.size() == 0;
				};				
			return comparator;
		}
		
		public static Function<TreeNode, Boolean> getComparatorUnproperChilds(){
			Function<TreeNode, Boolean> comparator = (left) -> {
					return left.childs.size() > 2;
				};				
			return comparator;
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
			TreeNodeProducerInputData inputData = new TreeNodeProducerInputData();
			inputData.inputLeft = lr[0];
			inputData.inputRight = lr[1];
			inputData.inputDataLeft = Integer.valueOf(inputData.inputLeft);
			inputData.inputDataRight = Integer.valueOf(inputData.inputRight);
			
			ctx.producerData =  ctx.nodeProducer.apply(inputData);

			TreeNode parent = createOrGetNode(ctx, ctx.producerData.computedParent.toString());
			String err = addChild(ctx, parent, ctx.producerData.computedChildValue.toString(), strDebug);
			return err;
		}

		public static String addChild(CtxOper ctx, TreeNode parent, String childVal, String strDebug) {
			addLeftChild(ctx, parent, childVal);
			return "";
		}

		public static void addLeftChild(CtxOper ctx, TreeNode parent, String childValue) {
			TreeNode child = createOrGetNode(ctx, childValue);
			child.parents.add( parent);
			parent.childs.add( child );
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

			return err;
		}

	}

	
	private static void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}		
	
}
