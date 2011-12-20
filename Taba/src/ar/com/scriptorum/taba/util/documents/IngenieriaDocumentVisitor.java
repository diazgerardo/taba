package ar.com.scriptorum.taba.util.documents;

public class IngenieriaDocumentVisitor implements DocumentVisitor {

	public void visit(OrdenTrabajo f) {
		f.setDepartment(Constants.INGENIERIA);
	}

	public void visit(AutorizacionIngreso r) {
		r.setDepartment(Constants.INGENIERIA);
	}

}
