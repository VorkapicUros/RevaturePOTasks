package com.revature.wcc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	int val;

	BinaryNode(int val) {
		this.val = val;
	}
}

public class JavaProblem {
	public static void main(String[] args) {
		BinaryNode root = generateTree();

		String simplifiedTree = printSimplifiedTree(root); // Use this for very big trees to save formatting headache.
		System.out.println(simplifiedTree);

		String formattedTree = printTree(root);
		System.out.println(formattedTree);

		String traversalPath = traverseTree(root);
		System.out.println("Traversal Path: " + traversalPath);
	}

	/**
	 * Does a breadth first traversal of binary tree returning the path it followed as a String.
	 * @param root BinaryNode root node of tree
	 * @return String
	 */
	private static String traverseTree(BinaryNode root) {
		StringBuilder traversalPath = new StringBuilder();
		LinkedList<BinaryNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode curr = queue.remove();
			if (curr.left != null) queue.add(curr.left);
			if (curr.right != null) queue.add(curr.right);
			traversalPath.append(curr.val).append(" -> ");
		}
		traversalPath.delete(traversalPath.length() - 4, traversalPath.length());
		return traversalPath.toString();
	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                    //
//           EVERYTHING BELOW HERE IS SUPERFLUOUS AND IS USED ONLY FOR GENERATING AND PRINTING BINARY TREES           //
//                                                                                                                    //
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * Very crude method for generating a tree based on a text file input.
	 * Text file should be formatted as such:
	 * 1st Line: max depth of tree, n
	 * 2nd Line: first node of tree, cannot be null
	 * Lines 3 to n+1: nodes of the tree in paired order read from left to right space separated.
	 * If a node should be empty, it should simply say "null".
	 * Each subsequent line should always have twice as many values as its previous line, otherwise
	 * you'll get out of bounds or null pointer exceptions.
	 * See example in src/main/resources/treeExamples.txt
	 * Current implementation DOES NOT support multiple trees in a single text file. Will only ever read the first tree.
	 * @return the head node of the tree, or null if something goes wrong.
	 */
	private static BinaryNode generateTree() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/treeExamples.txt"));
			int depth = Integer.parseInt(bf.readLine());
			BinaryNode head = new BinaryNode(Integer.parseInt(bf.readLine()));
			BinaryNode pointer = head;
			LinkedList<BinaryNode> queue = new LinkedList<>();

			for (int i = 1; i < depth; i++) {
				LinkedList<BinaryNode> nodes = Arrays.stream(bf.readLine().split(" "))
													 .map(s -> s.equals("null") ? null : new BinaryNode(Integer.parseInt(s)))
													 .collect(Collectors.toCollection(LinkedList::new));
				while (!nodes.isEmpty()) {
					if (pointer == null) {
						pointer = queue.remove();
						nodes.remove();
						nodes.remove();
						continue;
					}

					pointer.left = nodes.remove();
					queue.add(pointer.left);
					pointer.right = nodes.remove();
					queue.add(pointer.right);
					pointer = queue.remove();
				}
			}

			bf.close();
			return head;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Prints the tree in properly aligned tree fashion.
	 * May fail to format correctly for trees deeper than 5, and/or whose largest value is more than 2 digits long.
	 * Use printSimplifiedTree() in that case.
	 * @param root first node of tree
	 * @return String containing properly aligned tree.
	 */
	private static String printTree(BinaryNode root) {
		StringBuilder treeString = new StringBuilder();
		List<List<BinaryNode>> treeLevels = treeToList(root);
		int maxDepth = treeLevels.size();
		int maxDigitLength = String.valueOf(treeLevels.stream()
													  .flatMap(List::stream)
													  .max(Comparator.comparingInt(node -> node == null ? 0 : String.valueOf(node.val).length()))
													  .orElse(new BinaryNode(0)).val)
								   .length();
		for (int i = 0; i < maxDepth; i++) {
			String padding = repeat(" ", maxDigitLength * ((int) Math.pow(2, maxDepth - i) - 1));
			String sidePadding = repeat(" ", padding.length() - maxDigitLength*((int) Math.pow(2, maxDepth - i - 1)));
			treeString.append("Level ").append(i).append(": ");
			StringBuilder sb = new StringBuilder();
			for (BinaryNode node : treeLevels.get(i)) {
				String s;
				if (node == null) {
					s = repeat(" ", maxDigitLength);
				} else {
					s = String.valueOf(node.val);
				}
				int lenDiff = maxDigitLength - s.length();
				if (lenDiff != 0) {
					String p = repeat(" ", lenDiff / 2);
					if (lenDiff % 2 == 1) {
						s = " " + s;
					}
					sb.append(p).append(s).append(p);
				} else {
					sb.append(s);
				}
				sb.append(padding);
			}
			treeString.append(sidePadding).append(sb.replace(sb.length() - padding.length(), sb.length(), "")).append(sidePadding).append("\n");
		}
		return treeString.toString();
	}

	/**
	 * Prints tree in simplified form. Useful for excessively large trees.
	 * @param root first node of tree
	 * @return String containing simplified tree.
	 */
	private static String printSimplifiedTree(BinaryNode root) {
		StringBuilder treeString = new StringBuilder();
		List<List<BinaryNode>> treeLevels = treeToList(root);
		int maxDepth = treeLevels.size();
		for (int i = 0; i < maxDepth; i++) {
			treeString.append("Level ").append(i).append(": ");
			for (BinaryNode node : treeLevels.get(i)) {
				if (node == null) {
					treeString.append("null, ");
				} else {
					treeString.append(node.val).append(", ");
				}
			}
			treeString.replace(treeString.length() - 2, treeString.length(), "").append("\n");
		}
		return treeString.toString();
	}

	private static List<List<BinaryNode>> treeToList(BinaryNode root) {
		List<List<BinaryNode>> treeLevels = new ArrayList<>();
		treeLevels.add(new ArrayList<>(new ArrayList<>(Collections.singleton(root))));
		int level = 0;

		boolean allNull = false;
		while (!allNull) {
			boolean flag = true;
			treeLevels.add(new ArrayList<>());
			for (BinaryNode node : treeLevels.get(level)) {
				if (node == null) {
					treeLevels.get(level+1).add(null);
					treeLevels.get(level+1).add(null);
				} else {
					if (node.left != null || node.right != null) flag = false;
					treeLevels.get(level+1).add(node.left);
					treeLevels.get(level+1).add(node.right);
				}
			}
			level++;
			allNull = flag;
		}
		treeLevels.remove(level);
		return treeLevels;
	}

	// Since String.repeat() isn't introduced until Java 11, this function attempts to replicate its functionality.
	private static String repeat(String s, int count) {
		if (count < 0) {
			throw new IllegalArgumentException("count is negative: " + count);
		}
		if (count == 1) {
			return s;
		}
		if (s.length() == 0 || count == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
}