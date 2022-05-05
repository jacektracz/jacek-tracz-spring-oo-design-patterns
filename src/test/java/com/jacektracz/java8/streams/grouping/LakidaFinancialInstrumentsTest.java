package com.jacektracz.java8.streams.grouping;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

public class LakidaFinancialInstrumentsTest {
	
	@Test
	public void executeForEach_test() throws Exception {			
		LakidaFinancialInstrumentServices.executeForEach();
	}
	
	@Test
	public void executeGrouping_test() throws Exception {			
		LakidaFinancialInstrumentServices.executeGrouping();
	}
	
	@Test
	public void executePartitioning_test() throws Exception {			
		LakidaFinancialInstrumentServices.executePartitioning();
	}		
	
}

