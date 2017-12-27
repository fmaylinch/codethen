package samples.testing.util;

public class TestUtil {

	public static void assertEquals(Object actual, Object expected) {

		if (actual == expected) {
			return;
		}

		if (actual != null && !actual.equals(expected)) {
			throw new RuntimeException("actual " + actual + " is not equals to expected " + expected);
		}
	}

	public static void assertTrue(boolean actual) {

		if (!actual) {
			throw new RuntimeException("expected true but found false");
		}
	}
}
