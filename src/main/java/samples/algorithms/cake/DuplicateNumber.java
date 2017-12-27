package samples.algorithms.cake;

import java.util.Arrays;

/**
 * I have an array of n+1 numbers.
 * Every number in the range 1..n appears once except for one number that appears twice.
 * Write a method for finding the number that appears twice.
 *
 * https://www.interviewcake.com/question/java/which-appears-twice
 *
 * My solution uses the idea of XOR-ing the numbers, like here:
 * https://www.interviewcake.com/question/find-unique-int-among-duplicates
 *
 * There's a simpler solution:
 * XOR 1 through n and then XOR the result with each element in the list.
 */
public class DuplicateNumber {

	public static void main(String[] args) {

		check(1, new int[]{ 1, 2, 1 });
		check(2, new int[]{ 3, 2, 1, 2 });
		check(3, new int[]{ 7, 3, 4, 2, 5, 3, 8, 1, 6 });

		System.out.println("all test ok!");
	}

	private static void check(int expected, int[] array) {
		int actual = findRepeated(array);
		if (actual != expected) {
			throw new RuntimeException("Expected " + expected + " but found " + actual + " for " + Arrays.toString(array));
		}
	}

	/**
	 * Given an Array has n+1 numbers in range n..1, with only one repeated.
	 * This method returns that repeated number.
	 */
	private static int findRepeated(int[] array) {

		int xored = 0;
		int moreOdds = 0; // number of odds more than evens

		for (int x : array) {
			if (x % 2 == 0) {
				xored = xored ^ x;
				moreOdds--;
			} else {
				// "evenize" odd number, to cancel it with the pairing even
				// e.g. 1(+1) is cancelled with 2, 3(+1) with 4, etc.
				xored = xored ^ (x+1);
				moreOdds++;
			}
		}

		// if length (n+1) is even, n is odd so we have to add that n+1 number
		if (array.length % 2 == 0) {
			xored = xored ^ array.length;
		}

		// if we found more odds, that's the one repeated, so "un-evenize"
		return moreOdds == 0 ? xored : xored-1;
	}
}
