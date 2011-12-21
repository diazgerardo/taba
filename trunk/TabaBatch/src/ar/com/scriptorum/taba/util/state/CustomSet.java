package ar.com.scriptorum.taba.util.state;

import java.util.HashSet;

public class CustomSet<T> extends HashSet<T> {

	private static final long serialVersionUID = -3684776133520428553L;

	private String className;

	@Override
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

	public boolean eval(T t) {

		if (null == t)
			return false;
		if (this == t)
			return true;
		if (!(t instanceof CustomSet))
			return false;
		if (super.equals(t))
			return true;
		return false;

	}
}
