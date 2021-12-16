package com.jacektracz.letcode.bintree;
//https://coderbyte.com/solution/Tree%20Constructor#Java
	
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.jacektracz.letcode.bintree.TreeConstructorMain;
import com.jacektracz.letcode.bintree.TreeConstructorMain.TreeNodeCreator;
import com.jacektracz.letcode.bintree.TreeReversedConstructorMain.TreeReversedNodeCreator;

public class TreeReversedConstructorMainTest {
	
	@Test
	public void execTestSimplify() {
		new Simplify().update(LocalDate.of(2021, 10, 20));		
	}
		
	
	private void runGenericTestTF(String[] ll, String testIdx,String tf) {
		dbg("","");
		dbg("","");
		dbg("","");
		
		dbg("Test" + testIdx + "_start","");		
		String err = TreeReversedConstructorMain.TreeConstructor(ll);
		dbg(err,"");
		assertEquals(err,tf);
		dbg("Test" + testIdx + "end","");				
	}
	
		
	@Test
	public void execTest1() {
		String[] ll = new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"};
		runGenericTestTF(ll,"2","true");
		
	}
	
	@Test
	public void execTest2() {			
		String[] ll = new String[] {"(1,2)", "(2,4)", "(7,2)"};
		runGenericTestTF(ll,"2","true");						
	}
	
	@Test
	public void execTest7() {			
		String[] ll = new String[] {"(1,2)", "(2,4)", "(7,2)","(8,4)"};
		runGenericTestTF(ll,"3","true");				
	}
	
	@Test
	public void execTest3() {			
		String[] ll = new String[] {"(1,2)", "(2,4)", "(7,2)","(8,4)","(11,15)"};
		runGenericTestTF(ll,"3","false");		
	}
	
	@Test
	public void execTest4() {
		String[] ll = new String[] {"(1,2)", "(2,4)", "(7,2)","(8,2)"};
		runGenericTestTF(ll,"4","false");
				
	}
	
	@Test
	public void execTest5() {			
		String[] ll = new String[] {"(10,20)", "(20,50)"};
		runGenericTestTF(ll,"6","true");
	}

	
	@Test
	public void execTest6() {
		String[] ll = new String[] {"(5,6)", "(6,3)", "(2,3)", "(12,5)"};
		runGenericTestTF(ll,"6","true");
		
	}
	
	@Test
	public void execTest8() {
		String[] ll = new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)"};
		runGenericTestTF(ll,"8","false");
		
	}
	
	//new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)"}
	private void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}	
}
