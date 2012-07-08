package ar.com.scriptorum.threads.multithreading;

public class Body extends Part {
	public Body() {
		ClavoFactory.getInstance();
		this.id = ClavoFactory.serial;
	}

}
