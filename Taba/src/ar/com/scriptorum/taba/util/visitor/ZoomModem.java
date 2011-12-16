package ar.com.scriptorum.taba.util.visitor;

public class ZoomModem implements Modem {
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
			ZoomModemVisitor zv = (ZoomModemVisitor) v;
			zv.visit(this);
		} catch (ClassCastException e) {
		}
	}

	int configurationValue = 42;
}
