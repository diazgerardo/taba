package ar.com.scriptorum.threads.multithreading;

public class Tip extends Part{
	public Tip() {
		ClavoFactory.getInstance();
		this.id = ClavoFactory.serial;
	}

}
