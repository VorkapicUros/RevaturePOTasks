package com.revature.wcc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Integral {
	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/integralTests.txt"));
			String input = bf.readLine();
			while (input != null) {
				int[] arr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
				int b = arr[0];
				int m = arr[1];
				int n = arr[2];
				System.out.printf("The integral of: f(x) = (%d + 1) * x^%d from %d to %d is: ", b, b, m, n);
				System.out.println((long) (Math.pow(n, b + 1) - Math.pow(m, b + 1)));
				input = bf.readLine();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public static double integral(int b, int m, int n) {
		// Int

		return 0.0;
	}
}
