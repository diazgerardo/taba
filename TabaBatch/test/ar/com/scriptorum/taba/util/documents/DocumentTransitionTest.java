package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.factories.StateFactory;
import ar.com.scriptorum.taba.workflows.IngenieriaDocWkfl;

public class DocumentTransitionTest extends DocumentConfiguratorsTest {

	public DocumentTransitionTest(String test) {
		super(test);
	}

	public void testAutorizacionIngresoTransition() {

		assertNotNull(aiIng.getWorkflow());
		assertTrue(aiIng.getWorkflow() instanceof IngenieriaDocWkfl);
		assertNotNull(aiIng.getWorkflow().getCurrentState());
		assertTrue(StateFactory.newState("edited").equals(aiIng.getWorkflow().getCurrentState()));
		assertTrue(aiIng.getWorkflow().transicionate());
		assertTrue(StateFactory.newState("checked").equals(aiIng.getWorkflow().getCurrentState()));
		assertTrue(aiIng.getWorkflow().transicionate());
		assertTrue(StateFactory.newState("validated").equals(aiIng.getWorkflow().getCurrentState()));
		assertTrue(aiIng.getWorkflow().transicionate());
		assertTrue(StateFactory.newState("finalized").equals(aiIng.getWorkflow().getCurrentState()));
		
	}

}
