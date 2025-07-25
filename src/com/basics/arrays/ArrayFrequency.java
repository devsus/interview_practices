package com.basics.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayFrequency {

	public static void main(String[] args) {
		// Initialize array
		int[] arr = new int[] { 1, 2, 8, 3, 2, 2, 2, 5, 1 };
		// Array fr will store frequencies of element
		int[] fr = new int[arr.length];
		int visited = -1;
		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					// To avoid counting same element again
					fr[j] = visited;
				}
			}
			if (fr[i] != visited)
				fr[i] = count;
		}

		// Displays the frequency of each element present in array
		System.out.println("---------------------------------------");
		System.out.println(" Element | Frequency");
		System.out.println("---------------------------------------");
		for (int i = 0; i < fr.length; i++) {
			if (fr[i] != visited)
				System.out.println("    " + arr[i] + "    |    " + fr[i]);
		}
		System.out.println("----------------------------------------");

		// printing number of occurrence
		List<Integer> numList = Arrays.asList(2, 13, 4, 4, 2, 3, 5, 6, 1, 1);
		Map<Integer, Long> map = numList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		map.forEach((key, value) -> {
			System.out.println("ocuurance: " + key + "   " + value);
		});
		System.out.println("Start with 1-----------------------------");

	}
	
	public void primitiveToList() {
		int[] primitiveArray = {1, 2, 3, 4, 5};
		List<Integer> integers = Arrays.stream(primitiveArray).boxed().collect(Collectors.toList());
	}
}
