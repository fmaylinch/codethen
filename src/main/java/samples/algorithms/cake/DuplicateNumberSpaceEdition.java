package samples.algorithms.cake;

import samples.testing.util.TestUtil;

import java.util.Arrays;

/**
 * We have an array of integers that are in the range 1..n.
 * The array has a length of n+1.
 * It follows that our array has at least one integer which appears at least twice.
 * But it may have several duplicates, and each duplicate may appear more than twice.
 * Write a method which finds an integer that appears more than once in our array.
 * If there are multiple duplicates, you only need to find one of them.
 *
 * https://www.interviewcake.com/question/java/find-duplicate-optimize-for-space
 */
public class DuplicateNumberSpaceEdition {

	public static void main(String[] args) {

		TestUtil.assertTrue(Arrays.asList(7).contains(
			findDup(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 7})));

		TestUtil.assertTrue(Arrays.asList(2, 7).contains(
			findDup(new int[] {1, 2, 3, 4, 5, 2, 7, 8, 9, 7})));

		TestUtil.assertTrue(Arrays.asList(1, 2, 5).contains(
			findDup(new int[] {1, 1, 2, 2, 5, 5, 5, 5, 6, 7})));

		TestUtil.assertTrue(Arrays.asList(1).contains(
			findDup(new int[] {1, 2, 1})));

		TestUtil.assertTrue(Arrays.asList(1, 2).contains(
			findDup(new int[] {1, 2, 2, 1})));

		TestUtil.assertTrue(Arrays.asList(1, 2).contains(
			findDup(new int[] {1, 2, 2, 4, 1})));

		TestUtil.assertTrue(Arrays.asList(2).contains(
			findDup(new int[] {1, 2, 2, 4, 3})));
	}

	/*
	private static int findDup(int[] a) {
		return findDupRecursive(a, 1, a.length - 1);
	}
	*/

	/**
	 * Looks for a duplicated number x where lower <= x <= higher.
	 */
	private static int findDup(int[] a) {

		int lower = 1;
		int higher = a.length - 1;

		while (lower != higher) {

			final int half = lower + (higher - lower) / 2;
			int lowerCount = 0;

			for (int x : a) {
				if (lower <= x && x <= half) {
					lowerCount++;
				}
			}

			final int maxLowers = half - lower + 1;

			if (lowerCount > maxLowers) {
				higher = half;
			} else {
				lower = half+1;
			}
		}

		return lower;
	}

	/**
	 * Looks for a duplicated number x where lower <= x <= higher.
	 */
	private static int findDupRecursive(int[] a, int lower, int higher) {

		if (lower == higher) return lower; // we found a dup

		final int half = lower + (higher - lower) / 2;
		int lowerCount = 0;

		for (int x : a) {
			if (lower <= x && x <= half) {
				lowerCount++;
			}
		}

		final int maxLowers = half - lower + 1;

		if (lowerCount > maxLowers) {
			return findDupRecursive(a, lower, half); // there is a rep in the lower part
		} else {
			return findDupRecursive(a, half+1, higher); // there is a rep in the higher part
		}
	}
}
