package ar.com.scriptorum.workflow;

//import net.sf.cglib.proxy.Enhancer;

public class AMTUtils {

	/**
	 * 
	 * @param object, the object to obtain the class
	 * @return the original class of an Hibernate CGLIB Enhanced object 
	 * (classes with contains $$EnhancedCGLIB on their names)
	 */
	public static synchronized Class<?> getClassForEnhancedObject(Object object){
		
		if(Enhancer.isEnhanced(object.getClass()))
			return object.getClass().getSuperclass();
		else
			return object.getClass();	
		
	}
	
	static class Enhancer {

		public static boolean isEnhanced(Class<? extends Object> class1) {
			
			return false;
		}
		
	}
}
