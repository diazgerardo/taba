package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.factories.DocumentFactory;
import junit.framework.TestCase;


public class DocumentConfiguratorsTest extends TestCase {

	protected AutorizacionIngreso aiIng, aiOpe;
	private OrdenTrabajo otIng, otOpe;
	
	public DocumentConfiguratorsTest(String test) {
		super(test);
	}

	public void setUp() {
		aiIng = DocumentFactory.newAutorizacionIngreso(new IngenieriaDocumentVisitor());
		aiOpe = DocumentFactory.newAutorizacionIngreso(new OperacionesDocumentVisitor());
		otIng = DocumentFactory.newOrdenTrabajo(new IngenieriaDocumentVisitor());
		otOpe = DocumentFactory.newOrdenTrabajo(new OperacionesDocumentVisitor());
	}
	
	public void testAutorizacionIngresoConfiguradaPorIngenieria() {
		assertTrue(Constants.INGENIERIA.equals(aiIng.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(aiIng.getDocName()));
	}

	public void testAutorizacionIngresoConfiguradaPorOperaciones() {
		assertTrue(Constants.OPERACIONES.equals(aiOpe.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(aiOpe.getDocName()));
	}
	
	public void testOrdenTrabajoConfiguradaPorIngenieria() {
		assertTrue(Constants.INGENIERIA.equals(otIng.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(otIng.getDocName()));
	}

	public void testOrdenTrabajoConfiguradaPorOperaciones() {
		assertTrue(Constants.OPERACIONES.equals(otOpe.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(otOpe.getDocName()));
	}

}

