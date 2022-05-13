package com.jacektracz.java8.samples.executor;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import com.jacektracz.java8.samples.concurrent.JavaCyclicBarrierDesignPattern;

public class CyclicBarrierTest {

	@Test
	public void executeCallableGetString_test() throws Exception {
		
		JavaCyclicBarrierDesignPattern.executeCyclicBarrier();
	}		
	
	
}
