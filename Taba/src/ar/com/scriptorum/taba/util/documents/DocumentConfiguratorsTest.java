package ar.com.scriptorum.taba.util.documents;

import junit.framework.TestCase;


public class DocumentConfiguratorsTest extends TestCase {

	private IngenieriaConfigurator ic;
	private OperacionesConfigurator oc;
	private AutorizacionIngreso ai;
	private OrdenTrabajo ot;
	
	public DocumentConfiguratorsTest(String test) {
		super(test);
	}

	public void setUp() {
		ic = new IngenieriaConfigurator();
		oc = new OperacionesConfigurator();
		ai = new AutorizacionIngreso();
		ot = new OrdenTrabajo();
	}
	
	public void testAutorizacionIngresoConfiguradaPorIngenieria() {
		ai.accept(ic);
		assertTrue(Constants.INGENIERIA.equals(ai.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(ai.getDocName()));
	}

	public void testAutorizacionIngresoConfiguradaPorOperaciones() {
		ai.accept(oc);
		assertTrue(Constants.OPERACIONES.equals(ai.getDepartment()));
		assertTrue(Constants.AUTORIZACION_DE_INGRESO.equals(ai.getDocName()));
	}
	
	public void testOrdenTrabajoConfiguradaPorIngenieria() {
		ot.accept(ic);
		assertTrue(Constants.INGENIERIA.equals(ot.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(ot.getDocName()));
	}

	public void testOrdenTrabajoConfiguradaPorOperaciones() {
		ot.accept(oc);
		assertTrue(Constants.OPERACIONES.equals(ot.getDepartment()));
		assertTrue(Constants.ORDEN_DE_TRABAJO.equals(ot.getDocName()));
	}

}

