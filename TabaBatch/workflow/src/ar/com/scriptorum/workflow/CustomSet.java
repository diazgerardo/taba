package ar.com.scriptorum.workflow;

import java.util.LinkedHashSet;
import java.util.Set;

public class CustomSet<T> extends LinkedHashSet<T> {

	private static final long serialVersionUID = -3684776133520428553L;

	private String className;
	
	public CustomSet() {
		
	}
	
	public CustomSet(T t) {
		super();
		add(t);
	}

	public boolean add(T t) {
		boolean result = super.add(t);
		this.className = t.getClass().getSimpleName();
		return result;
	}

	@Override
	public String toString() {

		String customSet = this.className + "= { ";
		for (Object c : (Object[]) this.toArray()) {
			customSet += "[" + c + "] ";
		}
		return customSet + "}";
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object set) {
		if(null == set) return false;
		T[] expectedT = (T[])this.toArray();
		T[] receivedT = (T[])((Set<T>) set).toArray();
		if(expectedT.length!= receivedT.length)
			return false;
		for(int i = 0; i<expectedT.length;i++) {
			T e = expectedT[i];
			T r = receivedT[i];
			if(!e.equals(r))
				return false;
		}
		return true;
	}
}
