package ar.com.scriptorum.taba.util.visitor;

public class HayesModem extends BaseModem implements Modem {

	String configurationString;

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
		try {
			v.visit(this);
		} catch (ClassCastException e) {
		}
	}

}
