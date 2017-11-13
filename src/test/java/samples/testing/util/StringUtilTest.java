package samples.testing.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

	@Test
	public void testOneRepetition() {

		assertEquals("hello", StringUtil.repeat("hello", 1));
		assertEquals("a", StringUtil.repeat("a", 1));
		assertEquals("", StringUtil.repeat("", 1));
	}

	@Test
	public void testMultipleRepetitions() {

		assertEquals("byebyebye", StringUtil.repeat("bye", 3));
		assertEquals("aaaaa", StringUtil.repeat("a", 5));
		assertEquals("", StringUtil.repeat("", 10));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNegative() {

		StringUtil.repeat("hello", -1);
	}
}