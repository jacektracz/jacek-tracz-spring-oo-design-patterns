package com.jacektracz.trainings.stream;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class StreamsTraining {

	public static void main(String[] args) {
		new StreamsTraining().exeuteStreamsTraining();
	}
	
	public void exeuteStreamsTraining(){
		execCreate();
		execFilter();
		execGroups();
		execUnwrap();
	}

	public void execCreate() {
		Collection<SearchItemEntry> items = new ArrayList<SearchItemEntry>();
		items.add(new SearchItemEntry("c",5));
		items.add(new SearchItemEntry("d",8));
		items.add(new SearchItemEntry("f",9));
		Supplier<Collection<SearchItemEntry>> supplier = () -> items;

		Collection<SearchItemEntry> itemsC = createCollection(supplier);
		System.out.println(itemsC);		
	}
	
	public void execFilterByMethodReference() {
		Predicate<SearchItemEntry> olderThen = SearchItemEntry::filterAge;
		Collection<SearchItemEntry> itemsOlderThan18 = getFilteredItems(getCollection(), olderThen);
		System.out.println(itemsOlderThan18);
	}
	
	public void execFilter() {
		Predicate<SearchItemEntry> olderThen = cat -> cat.getAge() > 10;
		Collection<SearchItemEntry> itemsOlderThan18 = getItemsOlderThan(getCollection(), olderThen);
		System.out.println(itemsOlderThan18);
	}
	
	public void execFilterByStaticMethod() {
		Predicate<SearchItemEntry> olderThen = cat -> cat.getAge() > 10;
		Collection<SearchItemEntry> itemsOlderThan18 = getItemsOlderThanByStaticMethod(getCollection(), olderThen);
		System.out.println(itemsOlderThan18);
	}
	
	public void execGroups() {
		Map<String, List<SearchItemEntry>> nameToItemMap = groupItems(getCollection());
		System.out.println(nameToItemMap);
	}
	
	public void execUnwrap() {
		List<Optional<SearchItemEntry>> optionalItems = new ArrayList<Optional<SearchItemEntry>>();
		optionalItems.add(Optional.ofNullable(new SearchItemEntry("a",5)));
		optionalItems.add(Optional.ofNullable(new SearchItemEntry("b",6)));
		optionalItems.add(Optional.ofNullable(null));
		Collection<SearchItemEntry> unwrappedItems = unwrap(optionalItems);
		System.out.println(unwrappedItems);
	}
	
	public Collection<SearchItemEntry> getCollection() {
		Collection<SearchItemEntry> items = new ArrayList<SearchItemEntry>();
		items.add(new SearchItemEntry("c",5));
		items.add(new SearchItemEntry("d",8));
		items.add(new SearchItemEntry("f",9));
		items.add(new SearchItemEntry("fo",22));
		Supplier<Collection<SearchItemEntry>> supplier = () -> items;
		Collection<SearchItemEntry> itemsC = createCollection(supplier);		
		return itemsC;
	}
	
	public static Collection<SearchItemEntry> createCollection(Supplier<Collection<SearchItemEntry>> supplier) {
		return supplier.get();
	}

	public static Collection<SearchItemEntry> getItemsOlderThan(Collection<SearchItemEntry> items, 
			Predicate<SearchItemEntry> predicate) {
		
		return items.stream()
				.filter(cat -> predicate.test(cat))
				.collect(Collectors.toList());
	}
	
	public static Collection<SearchItemEntry> getItemsOlderThanByStaticMethod(Collection<SearchItemEntry> items, 
			Predicate<SearchItemEntry> predicate) {
		
		return items.stream()
				.filter(cat -> execTest(cat ,predicate))
				.collect(Collectors.toList());
	}
	

	public static boolean execTest(SearchItemEntry item, Predicate<SearchItemEntry> predicate) {
		return predicate.test(item);
	}
	
	public boolean execTestItem(SearchItemEntry item, Predicate<SearchItemEntry> predicate) {
		return predicate.test(item);
	}
	
	public static Map<String, List<SearchItemEntry>> groupItems(Collection<SearchItemEntry> items) {
		return items.stream()
				.collect(Collectors.groupingBy(SearchItemEntry::getName));
	}

	public static Collection<SearchItemEntry> unwrap(Collection<Optional<SearchItemEntry>> items) {

		Function<Optional<SearchItemEntry>, SearchItemEntry> mapper = c -> {
			if (c.isPresent()) {
				return c.get();
			} else {
				return null;
			}
		};

		return items.stream().map(mapper).filter(c -> c != null).collect(Collectors.toList());

	}
	
	public static void execSupplier() {
		String product = "Android";
		double price = 659.50;
		  
        BooleanSupplier boolSupplier = () -> product.length() == 10;
        IntSupplier intSupplier = () -> product.length() - 2;
        DoubleSupplier doubleSupplier = () -> price -20;
        LongSupplier longSupplier = () -> new Date().getTime();
        Supplier<String> supplier = () -> product.toUpperCase();
        
        
        System.out.println(boolSupplier.getAsBoolean());//false
        System.out.println(intSupplier.getAsInt());//5
        System.out.println(doubleSupplier.getAsDouble());//639.5
        System.out.println(longSupplier.getAsLong());// 1581187440978 (it depends on current time)
        System.out.println(supplier.get());//ANDROID
        
    }
	
	public static Collection<SearchItemEntry> getFilteredItems(Collection<SearchItemEntry> items, Predicate<SearchItemEntry> predicate) {
		
		return items
				  .stream()
				  .filter(predicate)
				  .collect(Collectors.toList());
		
	}	
}

