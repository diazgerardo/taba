package ar.com.scriptorum.taba.util.documents;

public class OrdenTrabajo extends AbstractDocument {

	public OrdenTrabajo() {
		setDocName(Constants.ORDEN_DE_TRABAJO);
	}

	public void accept(DocumentVisitor v) {
		v.visit(this);
	}

}
