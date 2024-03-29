package ar.com.scriptorum.patterns;

public class ObjectUtils <T> {

	T defaultInstance;

	public ObjectUtils(Class <T> t) {
		try {
			defaultInstance = t.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
 T safeGet(T e){
		   if(e == null){
			   e = (T) defaultInstance;
		   }
		   System.out.println(defaultInstance.hashCode());
		   return e;
		}

}
