package com.interview.crymsonlogic;

public class Test {

	public String solution(String string) {

		int count = 0;
		char ch[] = string.toCharArray();
		char c = 0;
		for (int i = 0; i < ch.length; i++) {
			for (int j = i + 1; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					count++;
					c = ch[i];
					System.out.println(c + "  " + count);
				}

			}

		}

		return "" + c;

	}

	public static void main(String[] args) {
		String string = new Test().solution("codility");

		System.out.println(string);

	}

}
