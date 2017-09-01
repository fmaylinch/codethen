package samples.labyrinth;

/**
 * Simple test util functions.
 */
public class TestUtil {

	/**
	 * Checks that the actual value we have is equal to the one we expect.
	 * In case they are different, throws an exception.
	 */
	public static void assertEquals(Object actual, Object expected) {

		if (!actual.equals(expected)) {
			throw new RuntimeException("Actual value " + actual + " not equals to expected " + expected);
		}
	}
}
