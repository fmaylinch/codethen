package samples.algorithms.geeks4geeks;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/longest-zig-zag-subsequence/
 *
 * I think the following solution is correct, and it's simpler and O(n)
 */
class ZigZagSubsequence {
    
	public static void main (String[] args) {
		
		// Scanner input = new Scanner(System.in);
		Scanner input = new Scanner("" +
			"2\n" +
			"6\n" +
			"5 5 10 100 10 5\n" +
			"3\n" +
			"1 2 3");

		final int T = input.nextInt();
		
		for (int t=1; t<=T; t++) {
		    
		    final int N = input.nextInt();

            // read array, because I wrote the solution with an array,
            // but it could be done just reading the input in one pass
		    final int[] a = new int[N];
		    for (int n=0; n<N; n++) {
		        a[n] = input.nextInt();
		    }
		    
		    // short array is a trivial zigZag
		    if (a.length <= 1) {
		        System.out.println(a.length);
		        continue;
		    }
		    
		    // skip equal numbers at the beginning to discover direction
		    int i = 1;
		    while (i < a.length && a[i] == a[i-1]) i++;
		    
		    int x = a[i];
		    boolean upNeeded = a[i-1] > a[i];
		    
		    // We could just count instead of storing the sequence
		    final List<Integer> zigZag = new ArrayList<>();
		    zigZag.add(a[i-1]);
		    
		    i++;
		    
		    while (i < a.length) {
		        if (a[i] != x) {
		            boolean upFound = a[i] > x;
		            if (upNeeded == upFound) {
		                zigZag.add(x);
		                x = a[i];
		                upNeeded = !upNeeded;
		            } else {
		                x = a[i];
		            }
		        }
		        i++;
		    }

			// add the last number, because we always defer adding
			// each number until we find the next zig/zag
		    zigZag.add(a[a.length-1]);
		    
		    System.out.println(zigZag.size());
		}
	}
}