package com.revature.wcc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * C#/.NET problem but done in Java.
 */
public class NETProblem {
	public static void main(String[] args) {
		NETProblem np = new NETProblem();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/c-sharp-samples.txt"));
			String s = bf.readLine();
			while (s != null) {
				int p = np.sockPairs(s);
				System.out.println(p + " Pair" + (p == 1 ? "" : "s"));
				s = bf.readLine();
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int sockPairs(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] carr = s.toCharArray();
		for (char c : carr) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		return map.values().stream().map(v -> v/2).reduce(Integer::sum).orElse(0);
	}
}
