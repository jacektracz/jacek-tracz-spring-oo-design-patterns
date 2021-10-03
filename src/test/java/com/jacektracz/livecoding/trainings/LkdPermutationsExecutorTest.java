package com.jacektracz.livecoding.trainings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class LkdPermutationsExecutorTest {

	@Test
	public void execPermutation() {			
		
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createDirectChilds("abc");
		dbg("Tree start" , "=================>");
		parentNode.executePrintChildsItemsOneLevel();
		dbg("Tree end" , "<=================");
		
		dbg("List start" , "=================>");
		parentNode.getComputedAllTreeItems();
		dbg("List end" , "<=================");

		dbg("List leaf start" , "=================>");
		parentNode.getComputedTreeLeafItems();
		dbg("List leaf end" , "<=================");
		
		List<LkdTreeNode> childs = parentNode.getComputedAllTreeItems();
		int size = childs.size();
		//dbg("Permutations","String perm: " + val);		 
		//dbg("Permutations","Tree perm: " + childs.size());		 		 
		//assertTrue(size == val);
		//assertEquals(size,val);
		
		
	}
	
	@Test
	public void checkAllLEvelsDown() {			
		testPermotationOfStringt("abc");		
	}

	@Test
	public void checkAllLEvelsDown_abcde() {
		testPermotationOfStringt("abcd");				
	}
	
	@Test
	public void checkAllLEvelsDown_a() {
		testPermotationOfStringt("a");				
	}
	
	private void testPermotationOfStringt(String ptest) {
		
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createTreeForInput(ptest);
		dbg("Tree start abcde" , "=================>");
		parentNode.executePrintChildsItemsAllLevels();
		dbg("Tree end abcde" , "<=================");
		
		dbg("List start abcde" , "=================>");
		parentNode.getComputedAllTreeItems();
		dbg("List end "  + ptest +  "" , "<=================");

		dbg("List leaf start " + ptest + "" , "=================>");
		parentNode.getComputedTreeLeafItems();
		dbg("List leaf end " + ptest + "" , "<=================");
		
		
		dbg("List leaf start abcde" , "=================>");
		parentNode.dbgStrPermutationNumbers(ptest);
		dbg("List leaf end " + ptest + "" , "<=================");
		
		int val = parentNode.getStringPermutationNumbers(ptest);
		 
		List<LkdTreeNode> childs = parentNode.getComputedTreeLeafItems();
		int size = childs.size();
		dbg("Permutations","String perm: " + val);		 
		dbg("Permutations","Tree perm: " + childs.size());		 		 
		assertTrue(size == val);
		assertEquals(size,val);
		
		dbg("Print all levels start","======================>");		 		
		parentNode.printComputedAllLevels();
		dbg("Print all levels end","======================>");
		
	}
	
	@Test
	public void execPermutationTestChilds_abc_0() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("abc",0);
				
		dbg("parent for abc(0)" , parentNode.getNodeIndicator());
		dbg("childs for abc(0)" , parentNode.getChildsIndicator());
		assertTrue(parentNode.getNodeIndicator().equals("a"));
		assertTrue(parentNode.getChildsIndicator().equals("bc"));
		
		assertEquals("a",parentNode.getNodeIndicator());
		assertEquals("bc",parentNode.getChildsIndicator());
		
	}

	@Test
	public void execPermutationTestChilds_abc_1() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("abc",1);
				
		dbg("parent for abc(1)" , parentNode.getNodeIndicator());
		dbg("childs for abc(1)" , parentNode.getChildsIndicator());
		assertTrue(parentNode.getNodeIndicator().equals("b"));
		assertTrue(parentNode.getChildsIndicator().equals("ac"));
		
		assertEquals("b",parentNode.getNodeIndicator());
		assertEquals("ac",parentNode.getChildsIndicator());
		
	}
	
	@Test
	public void execPermutationTestChilds_abc_2() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("abc",2);
				
		dbg("parent for abc(2)" , parentNode.getNodeIndicator());
		dbg("childs for abc(2)" , parentNode.getChildsIndicator());
		assertTrue(parentNode.getNodeIndicator().equals("c"));
		assertTrue(parentNode.getChildsIndicator().equals("ab"));
		
		assertEquals("c",parentNode.getNodeIndicator());
		assertEquals("ab",parentNode.getChildsIndicator());
		
	}

	@Test
	public void execPermutationTestChilds_abc_3() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("abc",3);
				
		dbg("parent for abc(3)" , parentNode.getNodeIndicator());
		dbg("childs for abc(3)" , parentNode.getChildsIndicator());
		
		assertEquals("",parentNode.getNodeIndicator());
		assertEquals("",parentNode.getChildsIndicator());
		
	}
	
	@Test
	public void execPermutationTestChilds_a_0() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("a",0);
				
		dbg("parent for a" , parentNode.getNodeIndicator());
		dbg("childs for a" , parentNode.getChildsIndicator());
		
		assertEquals("a",parentNode.getNodeIndicator());
		assertEquals("",parentNode.getChildsIndicator());
		
	}
	
	@Test
	public void execPermutationTestChilds_empty() {					
		LkdTreeNode parentNode = new LkdTreeNode();
		parentNode.createNodeAndChildsIndicators("",0);				
		dbg("parent for _" , parentNode.getNodeIndicator());
		dbg("childs for _" , parentNode.getChildsIndicator());
		
		assertEquals("",parentNode.getNodeIndicator());
		assertEquals("",parentNode.getChildsIndicator());
		
	}
	
	private void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string + ":" + reverted2);
	}

	
}

