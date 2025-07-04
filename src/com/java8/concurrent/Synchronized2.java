package com.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Synchronized2 {

	private static final int NUM_INCREMENTS = 10000;
	private static int count = 0;

	private static void testSyncIncrement() {
		count = 0;

		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(Synchronized2::incrementSync));

		ConcurrentUtils.stop(executor);

		System.out.println(count);
	}

	private static void incrementSync() {
		synchronized (Synchronized2.class) {
			count = count + 1;
		}
	}

	public static void main(String[] args) {
		testSyncIncrement();

	}

}
