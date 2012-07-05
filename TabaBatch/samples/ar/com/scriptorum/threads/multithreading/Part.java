package ar.com.scriptorum.threads.multithreading;

public class Part {

	protected int id;
	@Override
	public String toString() {
		return " Component: "+ this.getClass().getSimpleName()+"("+this.id+")";
	}
}
