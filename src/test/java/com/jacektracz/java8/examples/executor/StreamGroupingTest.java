package com.jacektracz.java8.examples.executor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import org.junit.jupiter.api.Test;

public class StreamGroupingTest {

	@Test
	public void shouldExecuteGrouping() throws Exception {
		
		com.jacektracz.java8.lambdasinaction.streams.grouping.Grouping.executeExamples();
	}
	
	@Test	
	public void shouldExecuteGroupingTransactions() throws Exception {
		
		com.jacektracz.java8.lambdasinaction.streams.grouping.GroupingTransactions.executeExamples();
	}
	
	
}
