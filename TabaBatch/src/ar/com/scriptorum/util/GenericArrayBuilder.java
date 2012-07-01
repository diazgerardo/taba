package ar.com.scriptorum.util;

import java.lang.reflect.Array;

/**
 * Helper class, hides reflection -used to build the generic array- from its
 * clients
 */

public class GenericArrayBuilder<E> {

	private E[] arrayBuilt;

	@SuppressWarnings("unchecked")
	public GenericArrayBuilder(E[] array, int size) {
		getGenericArrayBuilder((Class<E[]>) array.getClass(), size);
	}

	private void getGenericArrayBuilder(Class<E[]> clazz, int length) {
		arrayBuilt = clazz.cast(Array.newInstance(clazz.getComponentType(),
				length));
	}

	public E[] build() {
		return arrayBuilt;
	}

}