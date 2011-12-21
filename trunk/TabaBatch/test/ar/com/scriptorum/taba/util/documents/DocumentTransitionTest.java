package ar.com.scriptorum.taba.util.documents;

public class DocumentTransitionTest extends DocumentConfiguratorsTest {

	public DocumentTransitionTest(String test) {
		super(test);
	}

	public void testAutorizacionIngresoTransition() {
		assertTrue(aiIng.getWorkflow().transicionate());
	}

}
