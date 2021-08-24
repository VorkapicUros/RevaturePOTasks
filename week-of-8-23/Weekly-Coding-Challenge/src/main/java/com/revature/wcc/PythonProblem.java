package com.revature.wcc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Python problem but done in Java
 */
public class PythonProblem {
	public static void main(String[] args) {
		PythonProblem pp = new PythonProblem();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/python-samples.txt"));
			String s = bf.readLine(); // each line should be a pair of ints, see python-samples.txt for examples
			while (s != null) {
				int[] in = Stream.of(s.split(" ")).mapToInt(Integer::parseInt).toArray();
				System.out.println(pp.collatz(in[0], in[1]));
				s = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String collatz(int a, int b) {
		return steps(a) < steps(b) ? "a" : "b";
	}

	private long steps(int n) {
		return calculateSteps(n, 0);
	}

	private long calculateSteps(int n, long s) {
		return n == 1 ? s : calculateSteps(n % 2 == 0 ? n / 2 : 3*n+1, s+1);
	}
}
