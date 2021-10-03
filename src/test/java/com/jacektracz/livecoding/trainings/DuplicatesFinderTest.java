package com.jacektracz.livecoding.trainings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class DuplicatesFinderTest {

	
	@Test
	public void testFinder() {
		DuplicatesFinder handler = new DuplicatesFinder();
		List<String> names = Arrays.asList(
		           "Peter",
		           "Martin",
		         "John",
		        // "Peter",
		         "Vijay",
		        "Martin",
		        // "Peter",
		         "Arthur"
		        );		
		handler.findDuplicates(names);
	}
}
