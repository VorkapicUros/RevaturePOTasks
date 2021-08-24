package com.revature.wcc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class JavaProblem {
	public static void main(String[] args) {
		JavaProblem jp = new JavaProblem();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/java-samples.txt"));
			String s = bf.readLine();
			while (s != null) {
				System.out.println(s + (jp.isValidCard(s) ? " is a valid card" : " is an invalid card"));
				s = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isValidCard(String s) {
		if (s.length() < 14 || s.length() > 19) return false;
		final int checkDigit = Character.getNumericValue(s.charAt(s.length()-1));
		int[] digarr = Stream.of(new StringBuilder(s).deleteCharAt(s.length()-1).reverse().toString().split(""))
							 .mapToInt(Integer::parseInt)
							 .toArray();
		for (int i = 0; i < digarr.length; i+=2) {
			digarr[i] = digarr[i] < 5 ? digarr[i] * 2 : digarr[i] * 2 - 9;
		}
		int sum = Arrays.stream(digarr).reduce(Integer::sum).orElse(-1);
		return 10 - sum % 10 == checkDigit;
	}
}
