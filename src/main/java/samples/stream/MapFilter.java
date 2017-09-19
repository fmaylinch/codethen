package samples.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example of Java {@link Stream} and the popular functions
 * {@link Stream#filter}, {@link Stream#map} and {@link Stream#reduce}
 */
public class MapFilter {

	public static void main(String[] args) {

		// List of ints
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("nums: " + nums);

		// Filter numbers
		List<Integer> evens = nums.stream()
			.filter( x -> x % 2 == 0 )
			.collect(Collectors.toList());
		System.out.println("evens: " + evens);

		// Map to squares (x^2)
		List<Integer> squares = nums.stream()
			.map( x -> x * x )
			.collect(Collectors.toList());
		System.out.println("squares: " + squares);

		// Reduce to sum
		// Notes:
		// - With `r` I mean the reduced value (so far)
		// - `next` is the next value to "reduce"
		// - `r` starts with the given initial value (in this case: 0)
		int sum = nums.stream()
			.reduce(0, (r, next) -> r + next);
		System.out.println("sum: " + sum);


		// List of strings
		List<String> names = Arrays.asList("Peter", "Mary", "Anthony");
		System.out.println("names: " + names);

		// Map strings to their lengths
		List<Integer> lengths = names.stream()
			.map(name -> name.length())
			.collect(Collectors.toList());
		System.out.println("lengths: " + lengths);


		// We can combine map and filter multiple times (also reduce but only at the end)
		int result = nums.stream()
			.filter(x -> x < 5)
			.map(x -> x * 10)
			.filter(x -> x < 40)
			.reduce(1, (r, n) -> r * n);
		// TODO: try to guess the result and then see if you were right!
		// System.out.println("result: " + result);
	}
}
