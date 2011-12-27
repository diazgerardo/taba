package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.dao.UserDao;
import ar.com.scriptorum.taba.dao.impl.UserDaoMock;
import ar.com.scriptorum.taba.factories.StateBuilder;
import ar.com.scriptorum.taba.interfaces.Asignador;
import ar.com.scriptorum.taba.interfaces.User;
import ar.com.scriptorum.taba.interfaces.Workflow;
import ar.com.scriptorum.taba.util.state.State;
import ar.com.scriptorum.taba.workflows.IngenieriaDocWkfl;

public class DocumentTransitionTest extends DocumentConfiguratorsTest {

	public DocumentTransitionTest(String test) {
		super(test);
	}

	public void testAutorizacionIngresoTransition() {
		StateBuilder builder = new StateBuilder();
		assertNotNull(aiIng.getWorkflow());
		assertTrue(aiIng.getWorkflow() instanceof IngenieriaDocWkfl);
		Workflow<AbstractDocument> workflow = aiIng.getWorkflow();
		assertNotNull(workflow.getCurrentState());
		assertTrue(builder.createState("edited").build().equals(workflow.getCurrentState()));
		assertTrue(workflow.transicionate());
		assertTrue(builder.createState("checked").build().equals(workflow.getCurrentState()));
		assertTrue(workflow.transicionate());
		assertTrue(builder.createState("validated").build().equals(workflow.getCurrentState()));
		assertTrue(workflow.transicionate());
		assertTrue(builder.createState("finalized").build().equals(workflow.getCurrentState()));
		
	}
	
	public void testAutorizacionIngresoActions() {
		Workflow<AbstractDocument> workflow = aiIng.getWorkflow();
		StateBuilder builder = new StateBuilder();
		while(!builder.createState("validated").build().equals(workflow.getCurrentState())) {
			workflow.transicionate();
		}
		
		State state = workflow.getCurrentState();
		assertNotNull(state);
		UserDao dao = UserDaoMock.getInstance();
		User u = dao.findByName("boton");
		Asignador a = (Asignador) u;
		
	}


}
