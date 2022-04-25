package com.jacektracz.java8.streams.grouping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LakidaFinancialInstrumentServices {
	
	private static List<LakidaFinancialInstrument> musicalInstruments=new ArrayList<>();
	static {
		musicalInstruments.add(new LakidaFinancialInstrument("CDS","EXCH",299.99));
		musicalInstruments.add(new LakidaFinancialInstrument("Futures","EXCH",1149.0));
		musicalInstruments.add(new LakidaFinancialInstrument("SPI","OTC",2339.0));
		musicalInstruments.add(new LakidaFinancialInstrument("SWAP","OTC",325.00));
		musicalInstruments.add(new LakidaFinancialInstrument("Securities","SEC",5179.99));
		musicalInstruments.add(new LakidaFinancialInstrument("DEBT","debts",775.79));
	}
	
	public static void executeForEach () {
		System.out.println("Musical instruments in the collection:");
		
		musicalInstruments
		.stream()
		.forEach(instrument->System.out.println(instrument) );
	}
	
	public static void executeGrouping () {
		System.out.println("Group by type:");
		
		Stream <LakidaFinancialInstrument> instruments = musicalInstruments 
		.stream();
		
		Map<String,List<LakidaFinancialInstrument>> typeMap = 
		instruments
		.collect(Collectors.groupingBy(LakidaFinancialInstrument::getType));
		
		typeMap.forEach( (key, value)-> {System.out.println(key); value.forEach(System.out::println);});
	}
	
	public static void executePartitioning () {
		
		System.out.println("Partition by Affordable (less than or equal to $500) or Expensive (greater than $500) :");
		
		Stream <LakidaFinancialInstrument> instruments = musicalInstruments 
		.stream();
		
		Map<Boolean,List<LakidaFinancialInstrument>>  priceMap= instruments		
		.collect(Collectors.partitioningBy(musicalInstrument -> musicalInstrument.getPrice() > 500.0));
		
		priceMap.forEach( (key, value)-> {System.out.println((key? "Expensive ":"Affordable")); value.forEach(System.out::println);});
		
	}
	
}