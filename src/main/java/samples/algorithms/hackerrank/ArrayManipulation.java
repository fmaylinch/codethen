package samples.algorithms.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/crush
 */
public class ArrayManipulation {

    public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n+1];
        
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int k = in.nextInt();
            arr[a] += k;
            arr[b+1] -= k;
        }
        
        in.close();
        
        long max = 0;
        long curr = 0;
        
        for(int x : arr) {
            curr += x;
            if (curr > max) {
                max = curr;
            }
        }
        
        System.out.println(max);
    }
}