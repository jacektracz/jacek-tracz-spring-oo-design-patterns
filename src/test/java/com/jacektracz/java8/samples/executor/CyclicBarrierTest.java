package com.jacektracz.java8.samples.executor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import com.jacektracz.java8.samples.concurrent.JavaCompletableFutureDesignPattern;
import com.jacektracz.java8.samples.concurrent.JavaCyclicBarrierDesignPattern;
import com.jacektracz.java8.samples.concurrent.JavaExecutorCallableDesignPattern;

public class CyclicBarrierTest {

	@Test
	public void executeCallableGetString_test() throws Exception {
		
		JavaCyclicBarrierDesignPattern.executeCyclicBarrier();
	}		
	
	
}
