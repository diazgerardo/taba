package ar.com.scriptorum.taba.util.documents;

public class AutorizacionIngreso extends AbstractDocument {

	public AutorizacionIngreso() {
		setDocName(Constants.AUTORIZACION_DE_INGRESO);
	}

	public void accept(DocumentVisitor v) {
		v.visit(this);
	}
}
