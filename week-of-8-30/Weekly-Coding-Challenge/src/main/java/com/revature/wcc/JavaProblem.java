package com.revature.wcc;

import java.util.Arrays;
import java.util.LinkedList;

public class JavaProblem {
	public static void main(String[] args) {
		JavaProblem jp = new JavaProblem();
		int[] arr = jp.generateSortedArray(0, 100);
		Node root = jp.arrayToBinaryTree(arr);
		jp.printTree(root);
	}

	public Node arrayToBinaryTree(int[] arr) {
		if (arr.length == 1) return new Node(arr[0]);
		if (arr.length == 2) {
			Node curr = new Node(arr[1]);
			curr.left = new Node(arr[0]);
			curr.right = null;
			return curr;
		}
		int mid = arr.length / 2;
		Node curr = new Node(arr[mid]);
		curr.left = arrayToBinaryTree(Arrays.copyOfRange(arr, 0, mid));
		curr.right = arrayToBinaryTree(Arrays.copyOfRange(arr, mid + 1, arr.length));
		return curr;
	}

	// Generates a sorted array with all values between min and max inclusive.
	public int[] generateSortedArray(int min, int max) {
		int[] arr = new int[max - min];
		for (int i = 0; i < max - min; i++) {
			arr[i] = min + i;
		}
		return arr;
	}

	// Prints binary tree in very crude fashion.
	public void printTree(Node root) {
		int depth = 0;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		while (queue != null) {
			boolean flag = false;
			LinkedList<Node>subQueue = new LinkedList<>();
			System.out.print("Level " + depth++ + ": ");
			for (Node n : queue) {
				if (n == null) {
					System.out.print("[] ");
					flag = true;
				} else {
					subQueue.add(n.left);
					subQueue.add(n.right);
					System.out.print(n.val + " ");
				}
			}
			System.out.println();
			// If any nulls are detected in the for loop (aka the flag is flipped) then we must be at the bottom of the
			// binary tree. As a result, subQueue will only be null, and we can just set it equal to null.
			if (flag) subQueue = null;
			queue = subQueue;

		}
	}
}

class Node {
	Node left;
	Node right;
	int val;

	Node(int val) {
		this.val = val;
	}
}