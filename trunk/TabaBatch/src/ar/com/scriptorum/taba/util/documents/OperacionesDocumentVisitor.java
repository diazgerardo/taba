package ar.com.scriptorum.taba.util.documents;

public class OperacionesDocumentVisitor implements DocumentVisitor {

	public void visit(OrdenTrabajo f) {
		f.setDepartment(Constants.OPERACIONES);
	}

	public void visit(AutorizacionIngreso r) {
		r.setDepartment(Constants.OPERACIONES);
	}

}
