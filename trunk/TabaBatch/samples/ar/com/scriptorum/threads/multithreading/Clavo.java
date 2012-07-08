package ar.com.scriptorum.threads.multithreading;

public class Clavo {
	int id;
	Head head;
	Tip tip;
	Body body;
	public Clavo() {
		ClavoFactory.getInstance();
		this.id=ClavoFactory.serial;
	}
	public void setHead(Head head) {
		this.head=head;
	}
	public void setTip(Tip tip) {
		this.tip=tip;
	}
	public void setBody(Body body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return this.head.toString() + "\n" + this.body.toString() +"\n" + this.tip.toString(); 
	}
}
