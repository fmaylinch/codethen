package samples.algorithms.hackerrank;

import java.util.Arrays;

/**
 * Given an amount of money and an array of coin denominations
 * computes the number of ways to make the amount of money with coins
 * of the available denominations.
 */
public class CoinCombinations {

	/**
	 * Solution in time O(amount * coins) and space O(coins).
	 */
	public static void main(String[] args) {

		int amount = 7;
		int[] coins = {1, 2, 5};
		long[] result = new long[amount+1];
		result[0] = 1;

		for (int coin : coins) {

			for (int a = coin; a <= amount; a++) {

				final int rest = a - coin;
				result[a] += result[rest];
			}
		}

		System.out.println(Arrays.toString(result));
	}

	/**
	 * Solution in time O(amount * coins) and space O(amount * coins).
	 */
	public static void main2(String[] args) {

		int amount = 7;
		int[] coins = {1, 2, 5};

		// memo[a][c] contains the number of ways
		// to make the amount `a` with coins from `c` and greater.
		// e.g. you can use coins[c] or coins[c+1] but not coins[c-1]
		long[][] memo = new long[amount+1][coins.length];

		for (int a = 1; a <= amount; a++) {

			long count = 0;

			for (int c = coins.length-1; c >= 0; c--) {

				int rest = a - coins[c];

				if (rest == 0) { // exact match
					count++;
				} else if (rest > 0) {
					count += memo[rest][c];
				}

				memo[a][c] = count;

				System.out.println("a:" + a + ", c:" + c + " -> " + count);
			}

			System.out.println();
		}
	}
}
