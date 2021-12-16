package com.jacektracz.livecoding.trainings;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators.AbstractSpliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.w3c.dom.NodeList;

public class LkdTreeNode {
	
	private String nodeIndicator = "NOT_SET";
	private String childsIndicator = "NOT_SET";
	private String parentChildsIndicator = "NOT_SET";
	private Integer parentCurrentChildIndex = -1;
	private Integer nodeLevel = 0;
	private LkdTreeNode parentNode;
	private List<LkdTreeNode> childs = new ArrayList<>();

	public void createDirectChilds(final String parentChildsIndicator) {
		this.nodeIndicator = "X";
		this.childsIndicator = parentChildsIndicator;
		this.createDirectChildsFromChildsIndicator(parentChildsIndicator);	
	}

	public void createTreeForInput(final String parentChildsIndicator) {
		this.nodeIndicator = "X";
		this.parentChildsIndicator = parentChildsIndicator;
		this.childsIndicator = parentChildsIndicator;
		this.nodeLevel = 0;
		this.setParentCurrentChildIndex(-1);
		this.createNodeTreeChildsFromChildsIndicator();	
	}
	
	public void createNodeTreeChildsFromChildsIndicator() {
		
		if(this.getParentNode() != null) {
			String indicator = this.getParentNode().getChildsIndicator();
			this.setParentChildsIndicator(indicator);			
		}
		this.createDirectChildsFromChildsIndicator(
				this.childsIndicator);
		this.createTreeFromDirectChilds();		
	}
	
	public void createTreeFromDirectChilds() {
		childs.stream()
			.forEach(node -> node.createNodeTreeChildsFromChildsIndicator());				
	}
	
	public void createDirectChildsFromChildsIndicator(final String parentChildsIndicator) {			
		int length = parentChildsIndicator.length();
		if(length == 0) {
			return;
		}
		
		int version = 2;
		if(version == 0) {
			IntStream.range(0, length).forEach( index -> createChildNode(
					index,
					parentChildsIndicator,
					childs));
		}
		else if(version == 1) {		
			for (int ii = 0; ii < parentChildsIndicator.length(); ii++) {
				LkdTreeNode child = new LkdTreeNode();
				child.setParentNode(this);
				child.createNodeAndChildsIndicators(parentChildsIndicator, ii );
				childs.add(child);
			}
		}
		else if(version == 2) {
			this.childs = IntStream.range(0, length)
			.boxed()
			.map( index ->  getChildNode(index, parentChildsIndicator))
			.collect(Collectors.toList());
		}
		
	}
	
	public void createChildNode(int currentIndex,final String parentChildsIndicator,final List<LkdTreeNode> pchilds) {
		LkdTreeNode child = new LkdTreeNode();
		//child.setParentChildsIndicator( parentChildsIndicator);
		child.setParentCurrentChildIndex(currentIndex);
		child.setParentNode(this);
		child.createNodeAndChildsIndicators(parentChildsIndicator, currentIndex );
		child.computeAndSetNodeLevel();
		pchilds.add(child);		
	}
	
	public LkdTreeNode getChildNode(int currentIndex, final String parentChildsIndicator) {
		
		LkdTreeNode child = new LkdTreeNode();
		//child.setParentChildsIndicator( parentChildsIndicator);
		child.setParentCurrentChildIndex(currentIndex);
		child.setParentNode(this);		
		child.createNodeAndChildsIndicators(parentChildsIndicator, currentIndex );
		child.computeAndSetNodeLevel();
		return child;		
	}
	
	public void computeAndSetNodeLevel() {
		final List<LkdTreeNode> path = getNodesToRoot();
		this.nodeLevel = path.size()-1;		
	}	
	
	public void createNodeAndChildsIndicators( final String parentChildsIndicator, int currentIndex) {
		this.createNodeIndicator(parentChildsIndicator,currentIndex);
		this.createChildsIndicator(parentChildsIndicator,currentIndex);		
	}
	
	public void createNodeIndicator( final String parentChildsIndicator, int currentIndex) {
		final String nv = getNodeIndicatorFromParentChildsIndicatorForPosition(parentChildsIndicator, currentIndex);
		this.nodeIndicator = nv;
	}
	
	public void createChildsIndicator( final String parentChildsIndicator, int currentIndex) {
		//this.setParentChildsIndicator( parentChildsIndicator);		
		this.setParentCurrentChildIndex(currentIndex);
		final String right = getRightPartChildsIndicatorFromParentChildsIndicatorForIndexPosition(parentChildsIndicator, currentIndex);
		final String left = getLeftPartChildsIndicatorFromParentChildsIndicatorForIndexPosition(parentChildsIndicator, currentIndex);
		this.childsIndicator = left + right;
	}
	
	public static String getNodeIndicatorFromParentChildsIndicatorForPosition(final String parentChildsIndicator, int currentIndex) {
		String nv = "";
		if(currentIndex < parentChildsIndicator.length()) {
			nv = parentChildsIndicator.substring(currentIndex, currentIndex + 1);
		}
		return nv;
	}

	public static String getLeftPartChildsIndicatorFromParentChildsIndicatorForIndexPosition(final String parentChildsIndicator, int currentIndex) {
		String to = "";
		int len = parentChildsIndicator.length();
		if( currentIndex > 0 && currentIndex < len) {
			to = parentChildsIndicator.substring(0,currentIndex);
		}
		return to;
	}
	
	public static String getRightPartChildsIndicatorFromParentChildsIndicatorForIndexPosition(final String parentChildsIndicator, int parentIndex) {
		String nv = "";
		int childsIndexStart = parentIndex + 1;
		int len = parentChildsIndicator.length();
		if( childsIndexStart < len) {
			nv =  parentChildsIndicator.substring(childsIndexStart);			
		}
		return nv;
	}
	
	
	public void printChildsItems() {		
		executePrintChildsItemsOneLevel();
	}
	
	
	public void executePrintChildsItemsOneLevel() {
		this.executePrintChildItem();
		for (LkdTreeNode node : childs) {
			node.executePrintChildItem();
		}		
	}
	
	public void executePrintChildsItemsAllLevels() {
		this.executePrintChildItem();
		for (LkdTreeNode node : childs) {
			node.executePrintChildsItemsAllLevels();
		}		
	}
	
	public void executePrintChildItem() {
		printNode();
	}
	
	public String getNodeIndicator() {
		return nodeIndicator;
	}
	
	public void setNodeIndicator(final String nodeValue) {
		this.nodeIndicator = nodeValue;
	}
	
	private List<LkdTreeNode> getChilds() {
		return childs;
	}
	private void setChilds(final List<LkdTreeNode> childs) {
		this.childs = childs;
	}

	public String getChildsIndicator() {
		return childsIndicator;
	}

	public void setChildsIndicator(final String childsList) {
		this.childsIndicator = childsList;
	}
	

	public LkdTreeNode getParentNode() {
		return parentNode;
	}

	public void setParentNode(LkdTreeNode parent) {
		this.parentNode = parent;
	}
	
	public List<LkdTreeNode> getComputedTreeItems(){
		List<LkdTreeNode> items = new ArrayList<>();
		fillChildsItems(items);
		return items;
	}
	
	public List<LkdTreeNode> fillChildsItems(List<LkdTreeNode> items){
				
		items.add(this);
		for (LkdTreeNode node : childs) {
			node.fillChildsItems(items);
		}		
		
		return items;
		
	}
	
	public List<LkdTreeNode> getComputedAllTreeItems() {
		 List<LkdTreeNode> childs= getComputedTreeItems();
		 for (LkdTreeNode node : childs) {
				node.executePrintChildItem();
		}		
		 return childs;
	}
	
	public List<LkdTreeNode> getComputedTreeLeafItems() {
		 List<LkdTreeNode> childs= getComputedTreeItems();
		 List<LkdTreeNode> childsLeaf = new ArrayList<>();
		 for (LkdTreeNode node : childs) {
			 if(node.getChilds().isEmpty()) {
				node.executePrintChildItem();
				childsLeaf.add(node);
			 }
		}			 
		 return childsLeaf;
	}
	
	public List<LkdTreeNode> getComputedLevelNode(int level ) {
		Predicate<LkdTreeNode> treeNodeSelector = node -> node.getNodeLevel() == level;
		return getComputedTreeGeneric(treeNodeSelector);
	}

	public List<LkdTreeNode> printComputedAllLevels() {
		final Predicate<LkdTreeNode> treeNodeSelector = node -> node!=null;
		final List<LkdTreeNode> selectedNodes =  getComputedTreeGeneric(treeNodeSelector);
		int maxLevel = selectedNodes.size();		
		for (int ii = 0; ii < maxLevel;ii++) {
			
			 debugInfo ("Tree level start:" + ii);
			 final List<LkdTreeNode> nodes = printComputedLevelNode(ii);
			 debugInfo ("Tree level end:" + ii);
			 
			 if(nodes.size()==0) {
				 break;
			 }
			 
		}		
		return selectedNodes;
	}
	
	public List<LkdTreeNode> printComputedAllLevelsStreamed() {
		final Predicate<LkdTreeNode> treeNodeSelector = node -> node!=null;
		final List<LkdTreeNode> selectedNodes =  getComputedTreeGeneric(treeNodeSelector);
		int maxLevel = selectedNodes.size();		
		for (int ii = 0; ii < maxLevel;ii++) {
			 List<LkdTreeNode> nodes = printComputedLevelNode(ii);
			 if(nodes.size()==0) {
				 break;
			 }
		}
		
		return selectedNodes;
	}
	
	public List<LkdTreeNode> printComputedLevelNode(int level ) {
		Predicate<LkdTreeNode> treeNodeSelector = node -> node.getNodeLevel() == level;
		List<LkdTreeNode> selectedNodes =  getComputedTreeGeneric(treeNodeSelector);
		Consumer<LkdTreeNode> executor = node -> node.printNode();
		executeNodesActions(selectedNodes, executor);
		return selectedNodes;
	}

	public List<LkdTreeNode> printComputedLeafNodes(int level ) {
		Predicate<LkdTreeNode> treeNodeSelector = node -> node.getChilds().size() == 0;
		List<LkdTreeNode> selectedNodes =  getComputedTreeGeneric(treeNodeSelector);
		Consumer<LkdTreeNode> executor = node -> node.printNode();
		executeNodesActions(selectedNodes, executor);
		return selectedNodes;
	}
	
	public List<LkdTreeNode> getComputedTreeGeneric(final Predicate<LkdTreeNode> treeNodeSelector ) {
		 List<LkdTreeNode> childs= getComputedTreeItems();
		 return childs.stream()
				 .filter(treeNodeSelector)
				 .collect(Collectors.toList());
	}
	
	public int dbgStrPermutationNumbers(String strInput) {
		 int val = getStringPermutationNumbers(strInput);
		 List<LkdTreeNode> childs = getComputedTreeLeafItems();
		 debugInfo("String perm: " + val);		 
		 debugInfo("Tree perm: " + childs.size());
		 return val;		 
	}
	
	public int getStringPermutationNumbers(String strInput) {
		 int val = 1;
		 int len = strInput.length();
		 for (int ii = 1;ii <=len;ii ++) {
			 val = val*ii; 
		 }
		 return val;		 
	}
	
	public  List<LkdTreeNode> getNodesToRoot() {
		List<LkdTreeNode> path = new ArrayList<>();
		
		LkdTreeNode current = this;		
		String val = "";
		while(true) {			
			if (current == null ) {
				break;
			}
			path.add(current);			
			current = current.getParentNode();
		}
		return path;					
	}
	
	public  String getPathToRoot() {
		
		LkdTreeNode current = this;
		String val = "";
		while(true) {			
			if (current == null ) {
				break;
			}
			val = val + "[" + current.getNodeIndicator() + "]";
			current = current.getParentNode();
		}
		return val;					
	}

	private void printNode() {

		String parentNodeStr = "null";
		if(parentNode != null) {
			parentNodeStr = ("" + parentNode.getNodeIndicator() + "]");
		}
		String pathToRoot = getPathToRoot();
		debugInfo("node:"
				+ "[nodeLevel:" + this.nodeLevel + "]"
				+ "[nodeIndicator:" + this.nodeIndicator + " ]" 
				+ "[childsIndicator:" + this.childsIndicator + "]"
				+ "[parentIndicator:" + parentNodeStr + "]"
				+ "[parentChildsIndicator:" + this.parentChildsIndicator + "]"
				+ "[parentCurrentChildIndex:" + this.parentCurrentChildIndex + "]"				
				+ "[pathToRoot:" + pathToRoot + "]"				
				);
		
	}
	
	public List<LkdTreeNode> executeNodesActions(final List<LkdTreeNode> nodes, final Consumer<LkdTreeNode> consumer) {
		nodes.stream()
		.forEach(consumer);
		return nodes;
	}
	
	private void debugInfo(final String dbgTxt) {
		System.out.println(dbgTxt);
	}
	
	private void debugInfoVerbose(final String dbgTxt) {
		System.out.println(dbgTxt);
	}

	public String getParentChildsIndicator() {
		return parentChildsIndicator;
	}

	public void setParentChildsIndicator(String parentChildsIndicator) {
		this.parentChildsIndicator = parentChildsIndicator;
	}

	public Integer getParentCurrentChildIndex() {
		return parentCurrentChildIndex;
	}

	public void setParentCurrentChildIndex(Integer parentChildIndex) {
		this.parentCurrentChildIndex = parentChildIndex;
	}

	public Integer getNodeLevel() {
		return nodeLevel;
	}

	public void setNodeLevel(Integer nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
	
	public static <T> void streamWhile(Stream<T> stream, Predicate<? super T> predicate, Consumer<? super T> consumer) {
	    stream.peek(consumer).anyMatch(predicate.negate());
	}
	
	public static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> predicate) {
	    CustomSpliterator<T> customSpliterator = new CustomSpliterator<>(stream.spliterator(), predicate);
	    return StreamSupport.stream(customSpliterator, false);
	}
	
	static class CustomSpliterator<T> extends AbstractSpliterator<T> {

	    private Spliterator<T> splitr;
	    private Predicate<T> predicate;
	    private boolean isMatched = true;

	    public CustomSpliterator(Spliterator<T> splitr, Predicate<T> predicate) {
	        super(splitr.estimateSize(), 0);
	        this.splitr = splitr;
	        this.predicate = predicate;
	    }

	    public synchronized boolean tryAdvance(Consumer<? super T> consumer) {
	        boolean hadNext = splitr.tryAdvance(elem -> {
	            if (predicate.test(elem) && isMatched) {
	                consumer.accept(elem);
	            } else {
	                isMatched = false;
	            }
	        });
	        return hadNext && isMatched;
	    }
	}
	
}
