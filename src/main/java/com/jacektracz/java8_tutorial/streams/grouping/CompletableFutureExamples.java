package com.jacektracz.java8_tutorial.streams.grouping;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureExamples {
	
	
	
	public static void groupingExamples() {
		
		List<Person> roster = new ArrayList();
		
		Integer totalAgeReduce = roster
				   .stream()
				   .map(Person::getAge)
				   .reduce(
				       0,
				       (a, b) -> a + b);
		
		Averager averageCollect = roster.stream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .map(Person::getAge)
			    .collect(Averager::new, Averager::accept, Averager::combine);
			                   
		System.out.println("Average age of male members: " +
		    averageCollect.average());		
			
		double average = roster
			    .stream()
			    .filter(p -> p.getGender() == Person.Sex.MALE)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		
		Integer totalAgeReduce2 = roster
				   .stream()
				   .map(Person::getAge)
				   .reduce(
				       0,
				       (a, b) -> a + b);	
		
		
			
	}
	
	public static void executeCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();

        future.complete("42");

        future
                .thenAccept(System.out::println)
                .thenAccept(v -> System.out.println("done"));

    }	
	
	 public static void testCallable() throws InterruptedException, ExecutionException {
	        ExecutorService executorService = Executors.newSingleThreadExecutor();

	        Callable<String> callable = () -> {
	            // Perform some computation
	            System.out.println("Entered Callable");
	            Thread.sleep(2000);
	            return "Hello from Callable";
	        };

	        System.out.println("Submitting Callable");
	        Future<String> future = executorService.submit(callable);

	        // This line executes immediately
	        System.out.println("Do something else while callable is getting executed");

	        System.out.println("Retrieve the result of the future");
	        // Future.get() blocks until the result is available
	        String result = future.get();
	        System.out.println(result);

	        executorService.shutdown();
	        
	        CompletableFuture<String> completableFuture
	        = CompletableFuture.supplyAsync(() -> "Hello");

	      CompletableFuture<String> future2 = completableFuture
	        .thenApply(s -> s + " World");

	      logInfo("Hello World" +  future2.get());
	      
	      CompletableFuture<String> completableFuture3
	      = CompletableFuture.supplyAsync(() -> "Hello");

		    CompletableFuture<Void> future3 = completableFuture3
		      .thenAccept(s -> System.out.println("Computation returned: " + s));
	
		    future3.get();
	    
	 }
	 

	 public static void example2(String dbgInfo) throws InterruptedException, ExecutionException {
		 CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCombine(CompletableFuture.supplyAsync(
		      () -> " World"), (s1, s2) -> s1 + s2);

		 logInfo("Hello World:" + completableFuture.get());
	 }
	 

	 public static void example3(String dbgInfo) {
		 try {
			 CompletableFuture<String> future1  
			  = CompletableFuture.supplyAsync(() -> "Hello");
			CompletableFuture<String> future2  
			  = CompletableFuture.supplyAsync(() -> "Beautiful");
			CompletableFuture<String> future3  
			  = CompletableFuture.supplyAsync(() -> "World");
	
			CompletableFuture<Void> combinedFuture 
			  = CompletableFuture.allOf(future1, future2, future3);
	
			// ...
	
			combinedFuture.get();
	
			logInfo(future1.get());
			logInfo(future2.get());
			logInfo(future3.get());
		 }catch(Exception ex) {
			 
		 }
		
	 }
	 public static void example4(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static void example5(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static void example6(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static void example7(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static void example8(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static void example9(String dbgInfo) {
		 
	 }
	 public static void example10(String dbgInfo) {
		 
	 }
	 public static void example11(String dbgInfo) {
		 
	 }
	 
	 public static void logInfo(String logTxt) {
		 
	 }
	 
	 public static void logInfo(String logTxt, String logTx2) {
		 
	 }
	 
	public static class Person {

	    public enum Sex {
	        MALE, FEMALE
	    }

	    String name;
	    LocalDate birthday;
	    Sex gender;
	    String emailAddress;
	    int age;
	    // ...

	    public int getAge() {
	        // ...
	    	return age;
	    }

	    public String getName() {
	        // ...
	    	return name;
	    }
	    public Sex getGender() {
	        // ...
	    	return gender;
	    }
	    
	}	
}
