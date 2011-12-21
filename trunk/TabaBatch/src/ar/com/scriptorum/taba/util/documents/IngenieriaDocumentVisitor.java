package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.workflows.IngenieriaDocWkfl;

public class IngenieriaDocumentVisitor implements DocumentVisitor {

	public void visit(OrdenTrabajo ot) {
		commonBehaviour((AbstractDocument) ot);
	}

	public void visit(AutorizacionIngreso ai) {
		commonBehaviour((AbstractDocument) ai);
	}
	
	private void commonBehaviour(AbstractDocument d) {
		d.setDepartment(Constants.INGENIERIA);
		d.setWorkflow(new IngenieriaDocWkfl());
	}

}
