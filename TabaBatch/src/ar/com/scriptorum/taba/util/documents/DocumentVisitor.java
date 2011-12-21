package ar.com.scriptorum.taba.util.documents;

public interface DocumentVisitor {
	
	public void visit(OrdenTrabajo f);
	
	public void visit(AutorizacionIngreso r);

}
