package com.revature.wcc;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter contents of array, separated by spaces: ");
		String input = in.nextLine();
		int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		System.out.println("Min: " + arr[0]);
		System.out.println("Max: " + arr[arr.length-1]);
		Integer missing = findMissing(arr);
		if (missing != null) {
			System.out.println("Missing number: " + missing);
		}
	}

	public static Integer findMissing(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i-1] != 1) {
				return arr[i - 1] + 1;
			}
		}
		return null;
	}
}
