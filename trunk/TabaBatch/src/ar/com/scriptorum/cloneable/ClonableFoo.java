package ar.com.scriptorum.cloneable;


public class ClonableFoo {
	private int aPrimitive;
	public int getaPrimitive() {
		return aPrimitive;
	}
	public void setaPrimitive(int aPrimitive) {
		this.aPrimitive = aPrimitive;
	}
	public Object getAnObject() {
		return anObject;
	}
	public void setAnObject(Object anObject) {
		this.anObject = anObject;
	}
	
	private Object anObject;
	public ClonableFoo() {
		aPrimitive = 25252;
		anObject = new Object();
	}
	@Override
	public ClonableFoo clone() {
		ClonableFoo foo = new ClonableFoo();
		foo.setaPrimitive(this.getaPrimitive());
		foo.setAnObject(this.getAnObject());
		return foo;
	}
	
	@Override
	public boolean equals(Object o) {
		return true;
	}

}
