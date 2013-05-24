package ar.com.scriptorum.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionTest {

	@Test
	public void sampleMethodUsage() {
		
		Dumb o = null;
		try {
			o = Dumb.class.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Method[] methods = o.getClass().getMethods();
		
		for(Method m : methods) {
			Class[] clazzes = m.getParameterTypes();
			if("dumb".equals(m.getName())){
				for(Class c : clazzes) {
					System.out.print(" Method name:"+m.getName()+". Class name:");
					System.out.println(c.getName()+". ");
				}
				for(Object s: new Object[]{new Double(1),new Long(1),new Integer(1), 1.0D, 1, 1L}){		
					try {
							m.invoke(o,new Object[]{s});
					} catch (IllegalArgumentException e) {
						System.out.print("IllegalArgumentException");
					} catch (IllegalAccessException e) {
						System.out.print("IllegalAccessException");
					} catch (InvocationTargetException e) {
						System.out.print("InvocationTargetException");
					}
					System.out.print(", ");
				}
			}
			
			System.out.println();
		}
	}
}
