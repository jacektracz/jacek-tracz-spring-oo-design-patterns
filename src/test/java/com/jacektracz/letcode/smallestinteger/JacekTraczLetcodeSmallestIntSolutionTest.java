package com.jacektracz.letcode.smallestinteger;


import static org.junit.Assert.assertEquals;

//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

public class JacekTraczLetcodeSmallestIntSolutionTest {
	

	@Test		
	public void test1() throws Exception {
		int[] params = {1,3,6,4,1,2};
		JacekTraczLetcodeSmallestIntSolution handler = new JacekTraczLetcodeSmallestIntSolution();
		int outcome = handler.solution(params);
		assertEquals(outcome,5);
	}
	
	@Test		
	public void test2() throws Exception {
		int[] params = {1,3,6,4,1,2};
		JacekTraczLetcodeSmallestIntSolution handler = new JacekTraczLetcodeSmallestIntSolution();
		int outcome = handler.solution2(params);
		assertEquals(outcome,5);
	}
	
	
}
