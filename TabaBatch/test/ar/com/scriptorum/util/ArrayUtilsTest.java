package ar.com.scriptorum.util;

import junit.framework.TestCase;

public class ArrayUtilsTest extends TestCase {

	public final void testConcatTwoEmptyArrays() {

		String[] expected = ArrayUtils.concat(new String[] {}, new String[] {});
		assertNotNull(expected);

	}

	public final void testConcatNullToANonEmptyArray() {

		String[] nonEmptyArray = { "something" };
		String[] expected = { "something" };
		String[] received = ArrayUtils.concat(nonEmptyArray, null);
		assertTrue(expected.length == received.length);
		assertTrue(((String) expected[0]).equals((String) received[0]));

	}

	public final void testConcatTwoArrays() {

		String[] firstArray = { "first element", "second element" };
		String[] secondArrray = { "third element", "fourth element" };
		String[] expected = { "first element", "second element",
				"third element", "fourth element" };
		String[] received = ArrayUtils.concat(firstArray, secondArrray);
		assertTrue(expected.length == received.length);
		for (int i = 0; i < 4; i++)
			assertTrue(((String) expected[i]).equals((String) received[i]));

	}

	public final void testConcatNullStringToAnArray() {

		String[] anArray = { "first element", "second element" };
		String anString = null;
		String[] expected = { "first element", "second element" };
		String[] received = ArrayUtils.concat(anArray, anString);
		assertTrue(expected.length == received.length);
		for (int i = 0; i < 2; i++)
			assertTrue(((String) expected[i]).equals((String) received[i]));

	}

	public final void testConcatAnStringToAnArray() {

		String[] anArray = { "first element", "second element" };
		String anString = "third element";
		String[] expected = { "first element", "second element",
				"third element" };
		String[] received = ArrayUtils.concat(anArray, anString);
		assertTrue(expected.length == received.length);
		for (int i = 0; i < 3; i++)
			assertTrue(((String) expected[i]).equals((String) received[i]));

	}

	public final void testMergeTwoArrays() {

		String[] anArray = { "first element", "second element" };
		String[] anotherArray = { "second element" };
		String[] expected = { "first element", "second element" };
		String[] received = ArrayUtils.merge(anArray, anotherArray);
		assertTrue(expected.length == received.length);
		for (int i = 0; i < 2; i++)
			assertTrue(((String) expected[i]).equals((String) received[i]));

	}

	public final void testGenericArrayBuilder() {

		int maxStoreSize = 2500;
		Foo[] emptyFooArray = {};
		Object[] fooStore = getTemplateArray(emptyFooArray, maxStoreSize);

		// ASSERTIONS

		// 1st, make sure the array is of requested lenght
		assertTrue(fooStore.length == maxStoreSize);

		// 2nd, make sure each array component is NOT of Object type
		// (even if it has been received as an Object [])
		assertFalse((fooStore).getClass().getComponentType()
				.equals(Object.class));

		// 3rd, make sure each array member is of the type requested by
		// parameter
		assertTrue((fooStore).getClass().getComponentType().equals(Foo.class));

		// 4th, make sure whe can store an instance of the requested type into
		// the array
		assertTrue((fooStore[0] = new Foo()) != null);

	}

	private <T> T[] getTemplateArray(T[] foos, int size) {
		return new GenericArrayBuilder<T>(foos, size).build();
	}

	public class Foo {
	}

}
