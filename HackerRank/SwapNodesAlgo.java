/*============================================================================
  Problem     : Swap Nodes [Algo]
  Author      : Santiago Soto
  Copyright   : ssotom
  Version     : HackerRank - Accepted
  link        : https://www.hackerrank.com/challenges/swap-nodes-algo/problem
  Created on January 2021
 ============================================================================*/

import java.io.*;
import java.util.*;


class Node {
	private int value;
	private Node left;
	private Node right;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}

public class Solution {

	static void createTree(Node root, int[][] indexes) {
		Node current = root;

		Queue<Node> nodes = new LinkedList<>();
		nodes.offer(current);

		for (int[] index : indexes) {
			current = nodes.poll();
			int leftValue = index[0];
			if (leftValue != -1) {
				Node left = new Node(leftValue);
				current.setLeft(left);
				nodes.offer(left);
			}
			int rightValue = index[1];
			if (rightValue != -1) {
				Node right = new Node(rightValue);
				current.setRight(right);
				nodes.offer(right);
			}
		}
	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		int size = indexes.length;
		Node root = new Node(1);
		createTree(root, indexes);

		int[][] result = new int[queries.length][size];
		for (int i = 0; i < queries.length; i++) {
			swapNodes(root, queries[i], 1);
			List<Integer> list = new LinkedList<>();
			nodeToList(root, list);
			result[i] = list.stream().mapToInt(n -> n).toArray();
		}

		return result;
	}

	static void swapNodes(Node node, int k, int depth) {
		if (node == null) return;

		swapNodes(node.getLeft(), k, depth + 1);
		swapNodes(node.getRight(), k, depth + 1);

		if (depth >=k && depth % k == 0) {
			Node temp = node.getLeft();
			node.setLeft(node.getRight());
			node.setRight(temp);
		}
	}

	static void nodeToList(Node node, List<Integer> list) {
		if (node == null) return;

		nodeToList(node.getLeft(), list);
		list.add(node.getValue());
		nodeToList(node.getRight(), list);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scanner.nextLine().trim());

		int[][] indexes = new int[n][2];

		for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
			String[] indexesRowItems = scanner.nextLine().split(" ");

			for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
				int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
				indexes[indexesRowItr][indexesColumnItr] = indexesItem;
			}
		}

		int queriesCount = Integer.parseInt(scanner.nextLine().trim());

		int[] queries = new int[queriesCount];

		for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
			int queriesItem = Integer.parseInt(scanner.nextLine().trim());
			queries[queriesItr] = queriesItem;
		}

		int[][] result = swapNodes(indexes, queries);

		for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
			for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
				bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

				if (resultColumnItr != result[resultRowItr].length - 1) {
					bufferedWriter.write(" ");
				}
			}

			if (resultRowItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
