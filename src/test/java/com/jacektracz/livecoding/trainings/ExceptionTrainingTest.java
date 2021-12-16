package com.jacektracz.livecoding.trainings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class ExceptionTrainingTest {

	@Test
	public void execTEst() {
		
		ExceptionsTraining handler = new ExceptionsTraining();
		int result = handler.execTestMain();		
		assertEquals(result,0);		
	}
	
	
	private void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string + ":" + reverted2);
	}

	
}

