package com.java8.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Executors3 {
	//https://github.com/devsus/java8-tutorial-winterbe/blob/master/src/com/winterbe/java8/samples/concurrent/Executors3.java
   private static void test1() throws InterruptedException {
	   ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
	   Runnable task = () -> System.out.println("Scheduling:  "+System.currentTimeMillis());
	   int delay =3;
	   ScheduledFuture<?> future = executorService.schedule(task, delay, TimeUnit.SECONDS);
	   TimeUnit.SECONDS.sleep(1337);
	   long remainingDelay = future.getDelay(TimeUnit.SECONDS);
	   System.out.printf("Remaining Delay: %sms\n", remainingDelay);
   }
	
   private static void test2() {
       ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
       Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
       int initialDelay = 0;
       int period = 1;
       executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
   }
   private static void test3() {
       ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

       Runnable task = () -> {
           try {
               TimeUnit.SECONDS.sleep(2);
               System.out.println("Scheduling: " + System.nanoTime());
           }
           catch (InterruptedException e) {
               System.err.println("task interrupted");
           }
       };

       executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
   }
   private static void test4() throws InterruptedException {
       ExecutorService executor = Executors.newWorkStealingPool();

       List<Callable<String>> callables = Arrays.asList(
               () -> "task1",
               () -> "task2",
               () -> "task3");

       executor.invokeAll(callables)
               .stream()
               .map(future -> {
                   try {
                       return future.get();
                   }
                   catch (Exception e) {
                       throw new IllegalStateException(e);
                   }
               })
               .forEach(System.out::println);

       executor.shutdown();
   }
   private static void test5() throws InterruptedException, ExecutionException {
       ExecutorService executor = Executors.newWorkStealingPool();

       List<Callable<String>> callables = Arrays.asList(
               callable("task1", 2),
               callable("task2", 1),
               callable("task3", 3));

       String result = executor.invokeAny(callables);
       System.out.println(result);

       executor.shutdown();
   }

   private static Callable<String> callable(String result, long sleepSeconds) {
       return () -> {
           TimeUnit.SECONDS.sleep(sleepSeconds);
           return result;
       };
   }
	public static void main(String[] args) throws InterruptedException {
		test1();

	}

}
