package ar.com.scriptorum.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtils<T> {

	private ArrayUtils() {
	}

	public static <T> T[] concat(T[] firstArray, T[] secondArray) {

		try {
			T[] result = Arrays.copyOf(firstArray, firstArray.length
					+ secondArray.length);
			System.arraycopy(secondArray, 0, result, firstArray.length,
					secondArray.length);
			return result;
		} catch (Exception e) {
			return firstArray;
		}

	}

	public static <T> T[] concat(T[] anArray, T object) {

		if (null == object)
			return anArray;
		try {
			T[] result = Arrays.copyOf(anArray, anArray.length + 1);
			result[anArray.length] = object;
			return result;
		} catch (Exception e) {
			return anArray;
		}

	}

	public static <T> T[] merge(T[] firstArray, T[] secondArray) {

		try {
			return (T[]) removeDuplicates(concat(firstArray, secondArray));
		} catch (Exception e) {
			return firstArray;
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param mayHaveDuplicates
	 * @return T[]
	 * 
	 *         <LI>converts data from an array to a list, <LI>then to a set (to
	 *         discard duplicates), <LI>then converts it back to the generic
	 *         type
	 */
	public static <T> T[] removeDuplicates(T[] mayHaveDuplicates) {
		List<T> list = Arrays.asList(mayHaveDuplicates);
		Set<T> set = new HashSet<T>(list);
		T[] array = (T[]) set.toArray(new GenericArrayBuilder<T>(
				mayHaveDuplicates, set.size()).build());
		return array;

	}

}