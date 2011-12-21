package ar.com.scriptorum.taba.util.documents;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.factories.DocumentFactory;

public class DocumentTransitionTest extends TestCase {

	public void testAutorizacionIngresoTransition() {
		AutorizacionIngreso ai = DocumentFactory.newAutorizacionIngreso(new IngenieriaDocumentVisitor());
		ai.getWorkflow().transicionate();
	}

}
