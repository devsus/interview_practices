package com.guess.output;

import java.util.HashSet;
import java.util.Set;

public class Test8 {

	public static void main(String[] args) {
		Set<Short> s = new HashSet<>();
		for (short i = 0; i < 100; i++) {
			s.add(i);
			s.remove(i - 1);

		}
		System.out.println(s.size());

	}

}
