package com.revature.wcc;

import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("First Word: ");
		String A = "_" + in.nextLine();
		System.out.print("Second Word: ");
		String B = "_" + in.nextLine();
		int[][] dp = new int[A.length()][B.length()];

		// Dynamic programming approach. If when comparing the two words, their characters at index A[i] and B[j] equal
		// Then get whatever value was in the array at dp[i-1][j-1] (diagonal to current index), and set the current
		// index equal to its value, plus one.
		// If the characters at A[i] and B[j] do NOT equal each other, then we ignore the case, and simply set the
		// value at the current index dp[i][j] equal to whichever value is greater from dp[i-1][j] vs dp[i][j-1]
		// Basically we're checking the longest string at one letter back in each string.
		// The greater value indicates it's a longer sequence, and we only really want to track the longest sequences
		// By the end of the scan, the end of the array will have the longest common sequence length.
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}

		System.out.println(dp[A.length() - 1][B.length() - 1]);
	}
}
