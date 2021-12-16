package com.jacektracz.letcode.bintree;

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

public class TreeConstructorMainTest {
	
	@Test
	public void execTest1() {			
		//{"(1,2)(2,4)(5,7)(7,2)(9,5)"}
		dbg("Test1_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(2,3)");
		dbg(err,"");
		dbg("Test1_end","");
		assertTrue(err.isEmpty());
	}
	
	@Test
	public void execTest2() {			
		
		dbg("Test2_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(1,4)(1,5)");
		dbg(err,"");
		dbg("Test2_end","");
		assertTrue(!err.isEmpty());
		
	}
	
	@Test
	public void execTest3() {			
		
		dbg("Test2_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(3,5)");
		dbg(err,"");
		dbg("Test2_end","");
		assertTrue(!err.isEmpty());
		
	}
	
	@Test
	public void execTest4() {			
		
		dbg("Test2_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(3,5)(2,3)");
		dbg(err,"");
		dbg("Test2_end","");
		assertTrue(err.isEmpty());		
	}
	
	@Test
	public void execTest5() {			
		
		dbg("Test5_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(2,4)(5,7)(7,2)(9,5)");
		dbg(err,"");
		assertTrue(!err.isEmpty());
		dbg("Test5_end","");
		
		
	}
	
	@Test
	public void execTest6() {			
		
		dbg("Test6_start","");
		String err = TreeNodeCreator.checkConstructionFromStr("(1,2)(3,2)(2,12)(5,2)");
		dbg(err,"");
		assertTrue(!err.isEmpty());
		dbg("Test6_end","");		
		
	}
	
	private void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}	
}
