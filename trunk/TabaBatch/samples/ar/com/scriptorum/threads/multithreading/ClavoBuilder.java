package ar.com.scriptorum.threads.multithreading;

public class ClavoBuilder implements Runnable {

	static Clavo clavo;
	public ClavoBuilder() {
		clavo = new Clavo();
	}

	public void addHead() {
		clavo.setHead(new Head());
	}
	
	public void addBody() {
		clavo.setBody(new Body());
	}

	public void addTip() {
		clavo.setTip(new Tip());
	}

	@Override
	public void run() {
		addHead();
		addTip();
		addBody();
		ClavoFactory.getInstance().clavos.add(clavo);

	}

}
