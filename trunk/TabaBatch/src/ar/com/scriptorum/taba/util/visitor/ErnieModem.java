package ar.com.scriptorum.taba.util.visitor;

public class ErnieModem extends BaseModem implements Modem {

	String internalPattern;

	public void dial(String pno) {
	}

	public void hangup() {
	}

	public void send(char c) {
	}

	public char recv() {
		return 0;
	}

	public void accept(ModemVisitor v) {
		v.visit(this);
	}

}