package ar.com.scriptorum.workflow.util;

import java.util.Collection;
import java.util.Iterator;

public class CollectionUtils {
	
	public static Integer maxElement(Collection<Integer> collection){
		
		Integer maxElement = null;
		Iterator<Integer> iterator = collection.iterator();
		while (iterator.hasNext()){
			
			Integer integer = iterator.next();			
			
			if (maxElement == null){
				maxElement = integer;
			}else{
				if (integer.intValue() > maxElement.intValue()){
					maxElement = integer;
				}
			}
		}
		return maxElement;
	}	
}
