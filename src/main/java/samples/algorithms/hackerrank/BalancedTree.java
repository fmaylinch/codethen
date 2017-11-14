package samples.algorithms.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/self-balancing-tree
 */
public class BalancedTree {

	public static void main(String[] args) {

		Node root = new Node();
		root.val = 138;

		String input = "180 113 136 169 118 28 191 150 195 152 31 123 16 185 17 45 196 11 49 94 157 129 173 154 32 12 2 117 149 194 186 59 99 142 90 170 183 57 141 127 58 122 189 66 177 104 188";
		Scanner sc = new Scanner(input);

		while (sc.hasNextInt()) {
			root = insert(root, sc.nextInt());
		}

		printInOrder(root);
		System.out.println();
	}

	private static void printInOrder(Node root) {

		if (root == null) return;

		printInOrder(root.left);
		System.out.print(root.val + "(BF=" + balanceFactor(root) + ") ");
		printInOrder(root.right);
	}

	static class Node {
		int val;     //Value
		int ht;      //Height
		Node left;   //Left child
		Node right;  //Right child
	}

	static Node insert(Node root, int val)
	{
		println("inserting " + val);

		final boolean goesLeft = val < root.val;
		final Node node = goesLeft ? root.left : root.right;
		final Node other = goesLeft ? root.right : root.left;

		if (node != null) {

			setChild(root, goesLeft, insert(node, val));
			recalculateHeight(root); // Is it possible to know height without recalculation?

		} else {

			Node newNode = new Node();
			newNode.val = val;
			setChild(root, goesLeft, newNode);

			if (other == null) {
				root.ht++; // now root has children so height increased
			}
		}

		return balance(root);
	}

	private static Node balance(Node root) {

		if (balanceFactor(root) == 2) {

			if (balanceFactor(root.left) == -1) {
				println("left-right for node " + root.val);
				Node bubbled = root.left.right;
				Node b = bubbled.left;
				bubbled.left = root.left;
				bubbled.left.right = b;
				root.left = bubbled;
				// Recalculate heights
				bubbled.ht = bubbled.left.ht;
				recalculateHeight(bubbled.left);
			}

			println("left-left for node " + root.val);
			Node bubbled = root.left;
			root.left = bubbled.right;
			bubbled.right = root;
			root = bubbled;
			// Recalculate heights
			root.right.ht -= 2;

		} else if (balanceFactor(root) == -2) {

			if (balanceFactor(root.right) == 1) {
				println("right-left for node " + root.val);
				Node bubbled = root.right.left;
				Node c = bubbled.right;
				bubbled.right = root.right;
				bubbled.right.left = c;
				root.right = bubbled;
				// Recalculate heights
				bubbled.ht = bubbled.right.ht;
				recalculateHeight(bubbled.right);
			}

			println("right-right for node " + root.val);
			Node bubbled = root.right;
			root.right = bubbled.left;
			bubbled.left = root;
			root = bubbled;
			// Recalculate heights
			root.left.ht -= 2;
		}

		return root;
	}

	private static void println(String message) {
		//System.out.println(message);
	}

	private static void recalculateHeight(Node root) {
		root.ht = Math.max(height(root.left), height(root.right)) + 1;
	}

	static int height(Node node) {
		return node == null ? -1 : node.ht;
	}

	private static void setChild(Node root, boolean isLeftChild, Node child) {
		if (isLeftChild) {
			root.left = child;
		} else {
			root.right = child;
		}
	}

	static int balanceFactor(Node node) {
		if (node == null) return 0;
		int hl = node.left != null ? node.left.ht : -1;
		int hr = node.right != null ? node.right.ht : -1;
		return hl - hr;
	}

}
