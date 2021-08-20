package com.revature.wcc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordBucket {
	public static void main(String[] args) {
		WordBucket wb = new WordBucket();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/sample-text.txt"));
			String s = bf.readLine();
			while (s != null) {
				int n = Integer.parseInt(s);
				s = bf.readLine();
				List<String> list = wb.bucketize(s, n);
				System.out.println(list.toString());
				s = bf.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public List<String> bucketize(String s, int n) {
		String[] trough = s.split(" ");
		if (Arrays.stream(trough).anyMatch(l -> l.length() > n)) {
			return new ArrayList<>();
		}

		ArrayList<StringBuilder> buckets = new ArrayList<>();
		buckets.add(new StringBuilder());
		int index = 0;
		for (String word : trough) {
			StringBuilder bucket = buckets.get(index);
			if (bucket.length() + word.length() > n) {
				bucket.deleteCharAt(bucket.length() - 1);
				buckets.add(new StringBuilder(word + " "));
				index++;
			} else {
				bucket.append(word).append(" ");
			}
		}
		return buckets.stream().map(StringBuilder::toString).collect(Collectors.toList());
	}
}
