package samples.algorithms.cake;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverses the whole sentence, then reverses each word.
 */
public class WordsReverser {

	/** Reverses the position of words; e.g. "I love you" becomes "you love I" */
	public static void reverse(char[] sentence) {

		reverse(sentence, 0, sentence.length-1);

		int start = 0;

		for (int i = 0; i < sentence.length; i++) {
			if (sentence[i] == ' ') {
				reverse(sentence, start, i-1);
				start = i+1;
				i++;
			}
		}

		reverse(sentence, start, sentence.length-1);
	}

	/** Reverses chars in given inclusive range [from, to]. */
	private static void reverse(char[] a, int from, int to) {

		final int length = to - from + 1;
		final int halfLength = length / 2;

		for (int i = 0; i < halfLength; i++) {
			char c = a[to-i];
			a[to-i] = a[from+i];
			a[from+i] = c;
		}
	}


	public static void main(String[] args) {

		Map<String, String> tests = new HashMap<>();

		tests.put(
			"the words of this sentence will be reversed",
			"reversed be will sentence this of words the");
		tests.put(
			"single",
			"single");
		tests.put(
			"two words",
			"words two");
		tests.put(
			"same size",
			"size same");
		tests.put(
			"1 2 3 4 5",
			"5 4 3 2 1");
		tests.put(
			"cat bird crocodile",
			"crocodile bird cat");
		tests.put(
			"cat dog crocodile",
			"crocodile dog cat");

		System.out.println("Checking " + tests.size() + " sentences...");

		for (String str : tests.keySet()) {
			// try the two directions
			check(str, tests.get(str));
			check(tests.get(str), str);
		}

		System.out.println("done");
	}

	private static void check(String str, String expected) {

		try {
			char[] array = str.toCharArray();
			reverse(array);
			String reversed = new String(array);

			if (!expected.equals(reversed)) {
				System.out.println("Failed:");
				System.out.println("Original: " + str);
				System.out.println("Reversed: " + reversed);
			}
		} catch (Exception e) {

			System.out.println("Crashed:");
			System.out.println("Original: " + str);
			System.out.println("Error: " + e.toString());
		}
	}
}
