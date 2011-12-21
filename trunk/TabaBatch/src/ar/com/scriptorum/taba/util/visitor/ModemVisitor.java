package ar.com.scriptorum.taba.util.visitor;

public interface ModemVisitor {

	public void visit(HayesModem m);

	public void visit(ZoomModem m);

	public void visit(ErnieModem m);

}