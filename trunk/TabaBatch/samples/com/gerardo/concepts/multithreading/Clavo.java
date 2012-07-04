package com.gerardo.concepts.multithreading;

public class Clavo {
	int id;
	Head head;
	Tip tip;
	Body body;
	public Clavo() {
		this.id=ClavoFactory.getInstance().serial;
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
