package com.jacektracz.java8_tutorial.streams.grouping;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class GroupingExamples {
	
	
	
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
			 CompletableFuture<Integer> finalResult = compute(2).thenApply(s-> s + 1);
			 CompletableFuture<Integer> finalResult2 = compute(2).thenCompose(GroupingExamples::computeAnother);
			 
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static CompletableFuture<Integer> computeAnother(Integer i){
	     return CompletableFuture.supplyAsync(() -> 10 + i);
	 }
	 
	 public static CompletableFuture<Integer> compute(Integer i){
	     return CompletableFuture.supplyAsync(() -> 10 + i);
	 }
	 
	 public static void example5(String dbgInfo) {
		 try {
			 
			 Supplier<String> supplier = () -> supplyName("a1");
			 
			 CompletableFuture<String> completableFuture  			 
			  =  CompletableFuture.supplyAsync(supplier)
			  .handle((s, t) -> s != null ? s : "Hello, Stranger!");
			 
			 completableFuture.get();
			 
		 }catch(Exception ex) {
		 }
		 
	 }
	 
	 public static String supplyName( String name ) {
		 if (name == null) {
	          throw new RuntimeException("Computation error!");
	      }
	      return "Hello, " + name;
	 }
	 
	 /*  Worker thread example  ===> */
	 
	 public static void example6(String dbgInfo) {
		 try {
			//RejectedExecutionHandler implementation
		        RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
		        //Get the ThreadFactory implementation to use
		        ThreadFactory threadFactory = Executors.defaultThreadFactory();
		        //creating the ThreadPoolExecutor
		        ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
		        //start the monitoring thread
		        MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
		        Thread monitorThread = new Thread(monitor);
		        monitorThread.start();
		        //submit work to the thread pool
		        for(int i=0; i<10; i++){
		            executorPool.execute(new WorkerThread("cmd"+i));
		        }

		        Thread.sleep(30000);
		        //shut down the pool
		        executorPool.shutdown();
		        //shut down the monitor thread
		        Thread.sleep(5000);
		        monitor.shutdown();			 
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static class WorkerThread implements Runnable {

		    private String command;

		    public WorkerThread(String s){
		        this.command=s;
		    }

		    @Override
		    public void run() {
		        System.out.println(Thread.currentThread().getName()+" Start. Command = "+command);
		        processCommand();
		        System.out.println(Thread.currentThread().getName()+" End.");
		    }

		    private void processCommand() {
		        try {
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }

		    @Override
		    public String toString(){
		        return this.command;
		    }
	 }
	 
	 public static class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

		    @Override
		    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		        System.out.println(r.toString() + " is rejected");
		    }

	 }
	 
	 public static class MyMonitorThread implements Runnable
	 {
	     private ThreadPoolExecutor executor;
	     private int seconds;
	     private boolean run=true;

	     public MyMonitorThread(ThreadPoolExecutor executor, int delay)
	     {
	         this.executor = executor;
	         this.seconds=delay;
	     }
	     public void shutdown(){
	         this.run=false;
	     }
	     @Override
	     public void run()
	     {
	         while(run){
	                 System.out.println(
	                     String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
	                         this.executor.getPoolSize(),
	                         this.executor.getCorePoolSize(),
	                         this.executor.getActiveCount(),
	                         this.executor.getCompletedTaskCount(),
	                         this.executor.getTaskCount(),
	                         this.executor.isShutdown(),
	                         this.executor.isTerminated()));
	                 try {
	                     Thread.sleep(seconds*1000);
	                 } catch (InterruptedException e) {
	                     e.printStackTrace();
	                 }
	         }

	     }
	 }
	 
	 /*  <==== Worker thread example   */
	 
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

	 public static void example12(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static void example13(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static void example14(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static void example15(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 public static void example16(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }
		 
	 }
	 
	 public static void example17(String dbgInfo) {
		 try {
		 }catch(Exception ex) {
			 
		 }		 
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
	
	public static class HeapSort {
	    public void sort(int arr[])
	    {
	        int n = arr.length;
	 
	        // Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);
	 
	        // One by one extract an element from heap
	        for (int i = n - 1; i > 0; i--) {
	            // Move current root to end
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(arr, i, 0);
	        }
	    }
	 
	    // To heapify a subtree rooted with node i which is
	    // an index in arr[]. n is size of heap
	    void heapify(int arr[], int n, int i)
	    {
	        int largest = i; // Initialize largest as root
	        int l = 2 * i + 1; // left = 2*i + 1
	        int r = 2 * i + 2; // right = 2*i + 2
	 
	        // If left child is larger than root
	        if (l < n && arr[l] > arr[largest])
	            largest = l;
	 
	        // If right child is larger than largest so far
	        if (r < n && arr[r] > arr[largest])
	            largest = r;
	 
	        // If largest is not root
	        if (largest != i) {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;
	 
	            // Recursively heapify the affected sub-tree
	            heapify(arr, n, largest);
	        }
	    }
	 
	    /* A utility function to print array of size n */
	    static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 0; i < n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	 
	    // Driver code
	    public static void executeMain(String args[])
	    {
	        int arr[] = { 12, 11, 13, 5, 6, 7 };
	        int n = arr.length;
	 
	        HeapSort ob = new HeapSort();
	        ob.sort(arr);
	 
	        System.out.println("Sorted array is");
	        printArray(arr);
	    }
	}
	
}
