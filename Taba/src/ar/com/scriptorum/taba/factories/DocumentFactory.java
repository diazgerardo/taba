package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.util.documents.AutorizacionIngreso;
import ar.com.scriptorum.taba.util.documents.DocumentVisitor;
import ar.com.scriptorum.taba.util.documents.OrdenTrabajo;

public class DocumentFactory {

	public static AutorizacionIngreso newAutorizacionIngreso(DocumentVisitor v) {
		AutorizacionIngreso ai = new AutorizacionIngreso();
		ai.accept(v);
		return ai;
	}

	public static OrdenTrabajo newOrdenTrabajo(DocumentVisitor v) {
		OrdenTrabajo ot = new OrdenTrabajo();
		ot.accept(v);
		return ot;
	}

}
