package com.jacektracz.livecoding.trainings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class PalindroneTest {

	@Test
	public void execPalindorne() {
		
		String reverted  = PalindroneString.revertString("asa");
		assertTrue(reverted.equals("asa"));
		
		String reverted2  = PalindroneString.revertString("asad");
		assertTrue(reverted2.equals("dasa"));
		dbg("rev:", reverted2);
		
		assertTrue(PalindroneString.checkPalindrone("asa"));
		assertFalse(PalindroneString.checkPalindrone("asah"));
	}
	
	
	private void dbg(String string, String reverted2) {
		// TODO Auto-generated method stub
		System.out.println(string + ":" + reverted2);
	}

	
}

