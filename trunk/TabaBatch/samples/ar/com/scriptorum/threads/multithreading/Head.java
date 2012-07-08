package ar.com.scriptorum.threads.multithreading;

public class Head extends Part {
	public Head() {
		ClavoFactory.getInstance();
		this.id = ClavoFactory.serial;
	}
	
}
