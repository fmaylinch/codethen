package samples.algorithms.hackerrank;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle
 */
public class LargestRectangle {

    public static void main(String[] args) {

        System.out.println( largestRectangle(new int[]{3, 2, 5, 6, 1, 4, 4}) );
        System.out.println( largestRectangle(new int[]{1, 2, 3, 4, 5}) );
    }

    static long largestRectangle(int[] h) {

        Stack<Block> stack = new Stack<>();
        stack.push(new Block(0));

        long max = 0;

        for (int i = 0; i < h.length; i++) {
            int value = h[i];
            max = Math.max(max, processValue(stack, value));
        }

        max = Math.max(max, processValue(stack, 0)); // to close all blocks

        return max;
    }

    private static long processValue(Stack<Block> stack, int value) {

        long max = 0;

        Block top = stack.peek();

        if (value == top.value) {
			top.reps++;

		} else if (value > top.value) {
			stack.push(new Block(value));

		} else { // value < top.value

			int accReps = 0;

			while (value < top.value) {

				accReps += top.reps;
				long volume = (long)top.value * accReps;
				
                //System.out.println("Block of " + top.value + " * " + accReps + " = " + volume);

                max = Math.max(max, volume);

				stack.pop();
				top = stack.peek();
			}

			stack.push(new Block(value, accReps + 1));
            //System.out.println("Now top is: " + stack.peek());
		}

		return max;
    }

    private static class Block {

        Block(int value) {
            this(value, 1);
        }

        public Block(int value, int reps) {
            this.value = value;
            this.reps = reps;
        }

        int value;
        int reps;

        @Override
        public String toString() {
            return value + " (x " + reps + ")";
        }
    }
    
    public static void main_(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        long result = largestRectangle(h);
        System.out.println(result);
        in.close();
    }
}
