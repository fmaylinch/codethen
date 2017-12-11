package samples.algorithms.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/game-of-two-stacks
 */
public class TwoStacks {

	public static void main(String[] args) {

		String System_in = "4\n" +

			"0 4 10\n" +
			"\n" +
			"2 1 8 5\n" +

			"1 0 10\n" +
			"5\n" +
			"\n" +

			"1 1 10\n" +
			"11\n" +
			"11\n" +

			"5 4 10\n" +
			"4 2 4 6 1\n" +
			"2 1 8 5\n" +

			"12 7 25\n" +
			"1 3 5 5 1 1 1 1 1 1 1 3\n" +
			"2 4 4 4 4 2 3";

		Scanner in = new Scanner(System_in);
		int g = in.nextInt();
		for(int a0 = 0; a0 < g; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int[] a = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			int[] b = new int[m];
			for(int b_i=0; b_i < m; b_i++){
				b[b_i] = in.nextInt();
			}

			// your code goes here
			System.out.println(maxSteps(a, b, x));
		}
	}

	private static int maxSteps(int[] a0, int[] a1, int x) {

		// TODO: can be simplified
		// 1) take from a0 up to x and keep max
		// 2) take from a1 up to x restoring a0 when necessary and keep max

		Block b =  alwaysTakeMin(a0, a1, x);
		Block b0 = takeFromFirst(a0, a1, x, b);
		Block b1 = takeFromFirst(a1, a0, x, b.reversed()); // Reverse the counts

		// System.out.println(b);
		// System.out.println(b0);
		// System.out.println(b1);

		return Math.max(b0.totalCount(), b1.totalCount());
	}

	/**
	 * From situation described in b, restore (push) numbers in a1 and take (pop) numbers from a0
	 * until it's not possible anymore (a0 is empty or a1 is restored completely).
	 *
	 * @return the block with maximum totalCount (maybe it's equal to b, if b had already the maximum count).
	 */
	private static Block takeFromFirst(int[] a0, int[] a1, int x, Block b) {

		Block current = new Block(b);
		Block max = new Block(current);

		// a0 is not empty
		while (current.count[0] < a0.length) {

			int value = a0[current.count[0]];

			if (current.sum + value <= x) {
				// Take a number from a0 if sum doesn't exceed x
				current.sum += value;
				current.count[0]++;
				if (current.totalCount() > max.totalCount()) {
					max = new Block(current);
				}
			} else if (current.count[1] > 0) {
				// If a1 is not restored, restore a number to a1
				current.count[1]--;
				current.sum -= a1[current.count[1]];
			} else {
				break; // can't take from a0 or restore to a1
			}
		}

		return max;
	}

	/**
	 * Take always minimum value from top of a0 or a1 until we reach the maximum sum where sum <= x.
	 * @return block with calculated sum and count of numbers taken from each stack.
	 */
	private static Block alwaysTakeMin(int[] a0, int[] a1, int x) {

		Block b = new Block();

		int[][] arrays = {a0, a1}; // Put arrays into an array for easy access (simplifies logic below)

		while (b.count[0] < a0.length || b.count[1] < a1.length) {

			final int minArrayIndex; // Index of the array that contains the min value

			if (b.count[0] < a0.length && (b.count[1] >= a1.length || a0[b.count[0]] < a1[b.count[1]])) {
				minArrayIndex = 0; // a0 has the min value
			} else {
				minArrayIndex = 1; // a1 has the min value
			}

			int value = arrays[minArrayIndex][b.count[minArrayIndex]];

			if (b.sum + value <= x) {
				b.sum += value;
				b.count[minArrayIndex]++;
			} else {
				break;
			}
		}

		return b;
	}


	/** Block of selected numbers from the stacks */
	static class Block {

		/** total sum of selected numbers */
		int sum;
		/** count of numbers taken from each of the 2 stacks */
		int[] count;

		public Block() {
			sum = 0;
			count = new int[] {0, 0};
		}

		public Block(Block b) {
			this.sum = b.sum;
			this.count = new int[]{ b.count[0], b.count[1] };
		}

		public int totalCount() {
			return count[0] + count[1];
		}

		public Block reversed() {
			Block result = new Block();
			result.sum = sum;
			result.count = new int[]{ count[1], count[0] };
			return result;
		}

		@Override
		public String toString() {
			return "{" + "sum=" + sum + ", count=" + Arrays.toString(count) + '}';
		}
	}
}
