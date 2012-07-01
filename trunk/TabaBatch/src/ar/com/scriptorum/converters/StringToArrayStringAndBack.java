package ar.com.scriptorum.converters;

import static junit.framework.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class StringToArrayStringAndBack {

	private static String [] anArrayWithDuplicatedvalues = {"a1","a2","a2","a3"};
	
	public static void main(String [] args ) {
		
		MisUtiles<String> util = new MisUtiles<String>();
		String[] withoutDuplicates = util.removeDuplicates(anArrayWithDuplicatedvalues);
		assertTrue(withoutDuplicates != null);
		
	}
	
	
	
}

class MisUtiles <T> {

	public MisUtiles() {
		
		
	} 
	
	public T[] removeDuplicates(T[] mayHaveDuplicates) {
		List<T> list = Arrays.asList( mayHaveDuplicates );
		Set<T> set = new HashSet<T>( list );
		@SuppressWarnings("unchecked")
		T[] array = (T[])set.toArray(((T[])Array.newInstance(mayHaveDuplicates.getClass(), 0)));
		//String [] array = (String[])set.toArray( new String[]{} );
		return array;
	}
}

