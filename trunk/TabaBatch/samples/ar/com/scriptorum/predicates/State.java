package ar.com.scriptorum.predicates;

public class State {

	public static final Object WI = new State("Wisconsin");
	public static final Object AZ = new State("Arizona");
	public static final Object MI = new State("Michigan");
	private String fullyQualifiedName;
	public State(String fullyQualifiedName) {
		this.fullyQualifiedName = fullyQualifiedName;
	}
	public char[] getFullyQualifiedName() {
		return fullyQualifiedName.toCharArray();
	}

	public String toString() {
		return fullyQualifiedName;
	}
}
