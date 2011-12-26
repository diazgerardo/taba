package ar.com.scriptorum.taba.util.state;

import java.lang.reflect.Method;

public class ListMethodsAction <T> implements Action {
	
	T target;
	
	public ListMethodsAction(T a) {
		target = a;
	}
	
	@Override
	public boolean execute() {
		System.out.println(target.getClass().getSimpleName());
		Method[] methods = target.getClass().getMethods();
		for(Method m : methods) {
			System.out.println(m);
		}
		return true;
	}

}
