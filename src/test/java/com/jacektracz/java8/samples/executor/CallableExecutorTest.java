package com.jacektracz.java8.samples.executor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import com.jacektracz.java8.samples.concurrent.JavaExecutorCallableDesignPattern;

public class CallableExecutorTest {

	@Test
	public void executeCallableGetString_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeCallableGetString();
	}		
	
	@Test
	public void executeLambaRunnableDelayed_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeLambaRunnableDelayed();
	}
	
	@Test
	public void executeLambaRunnableAtFixedRate_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeLambaRunnableAtFixedRate();
	}		
	
	@Test
	public void executeRunnableScheduledFuture_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeRunnableScheduledFuture();
	}		
	
	@Test
	public void executeCallableListOfMethodsInvokeAny_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeCallableListOfMethodsInvokeAny();
	}
	
	@Test
	public void executeCallableListOfMethodsInvokeAll_test() throws Exception {
		
		JavaExecutorCallableDesignPattern.executeCallableListOfMethodsInvokeAll();
	}		
	
}
