package samples.algorithms;

import java.util.*;

/**
 *
 * Assume that we are given n pairs of items as input, where the first item is a
 * number and the second item is one of three colors (red, blue, or yellow). Further
 * assume that the items are sorted by number. Give an O(n) algorithm to sort the
 * items by color (all reds before all blues before all yellows) such that the numbers
 * for identical colors stay sorted.
 * For example: (1,blue), (3,red), (4,blue), (6,yellow), (9,red), (10,red), (12,blue)
 * should become (3,red), (9,red), (10,red), (1,blue), (4,blue), (12,blue), (6,yellow)
 */
public class NumberColor {

	public static void main(String[] args) {

		List<Pair> input = Arrays.asList(
			new Pair(1, "blue"),
			new Pair(3, "red"),
			new Pair(4, "blue"),
			new Pair(6, "yellow"),
			new Pair(9, "red"),
			new Pair(10, "red"),
			new Pair(12, "blue")
		);

		System.out.println(input);


		// For each color we keep a list of numbers.
		// We're using LinkedHashMap to keep color order as we put them.
		// If we don't need to keep that order, a simple HashMap is enough.
		Map<String, List<Integer>> map = new LinkedHashMap<>();
		// The exercise wants "all reds before all blues before all yellows"
		map.put("red", new ArrayList<>());
		map.put("blue", new ArrayList<>());
		map.put("yellow", new ArrayList<>());


		// O(n) because map operations take O(1) and we loop through all n pairs
		for (Pair pair : input) {
			map.get(pair.color).add(pair.value);
		}

		// Imaginary structure of the hash map
		// when we have added all the numbers for "blue"
		//
		//  [0]
		//  [1]
		//  [2]
		//  ...
		//  [184]  (hashCode for "blue") --> [1, 4, 12]
		//  ...
		//  [999]
		//  [1000]


		// Print all the colors and their numbers
		for (String color : map.keySet()) {
			for (Integer number : map.get(color)) {
				System.out.println("(" + number + "," + color + ")");
			}
		}
	}


	static class Pair {

		Pair(int value, String color) {
			this.value = value;
			this.color = color;
		}

		int value;
		String color;

		@Override
		public String toString() {
			return "(" + value + "," + color + ")";
		}
	}
}
