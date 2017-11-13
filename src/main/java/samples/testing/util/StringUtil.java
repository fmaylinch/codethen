package samples.testing.util;

public class StringUtil {

	/**
	 * Returns the given string repeated n times.
	 * If n is 0, returns an empty string.
	 * n must be 0 or greater.
	 */
	public static String repeat(String str, int n) {

		if (n < 0) {
			throw new IllegalArgumentException("negative n not allowed");
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			sb.append(str);
		}

		return sb.toString();
	}
}
