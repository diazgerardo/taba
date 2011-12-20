package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.factories.DocumentFactory;
import junit.framework.TestCase;


public class DocumentConfiguratorsTest extends TestCase {

	private AutorizacionIngreso ai;
	private OrdenTrabajo ot;
	
	public DocumentConfiguratorsTest(String test) {
		super(test);
	}

	public void testAutorizacionIngresoConfiguradaPorIngenieria() {
		ai = DocumentFactory.newAutorizacionIngreso(new IngenieriaDocumentVisitor());
		assertTrue(Constants.INGENIERIA.equals(ai.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(ai.getDocName()));
	}

	public void testAutorizacionIngresoConfiguradaPorOperaciones() {
		ai = DocumentFactory.newAutorizacionIngreso(new OperacionesDocumentVisitor());
		assertTrue(Constants.OPERACIONES.equals(ai.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(ai.getDocName()));
	}
	
	public void testOrdenTrabajoConfiguradaPorIngenieria() {
		ot = DocumentFactory.newOrdenTrabajo(new IngenieriaDocumentVisitor());
		assertTrue(Constants.INGENIERIA.equals(ot.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(ot.getDocName()));
	}

	public void testOrdenTrabajoConfiguradaPorOperaciones() {
		ot = DocumentFactory.newOrdenTrabajo(new OperacionesDocumentVisitor());
		assertTrue(Constants.OPERACIONES.equals(ot.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(ot.getDocName()));
	}

}

