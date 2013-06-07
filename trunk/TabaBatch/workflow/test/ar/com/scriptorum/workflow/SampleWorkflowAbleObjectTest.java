package ar.com.scriptorum.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.com.scriptorum.workflow.SampleWorkflowAbleObject;
import ar.com.scriptorum.workflow.State;
import ar.com.scriptorum.workflow.StateBuilder;
import ar.com.scriptorum.workflow.Workflow;
import ar.com.scriptorum.workflow.WorkflowAble;


public class SampleWorkflowAbleObjectTest {
	
	public static WorkflowAble sampleBusinessObject;
	State expected;
	ApplicationContext ctx;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("workflow.test.application.context.xml");		
		sampleBusinessObject = (SampleWorkflowAbleObject) ctx.getBean("sampleBusinessObject"); //new Order();
		//sampleBusinessObject.initializeWorkflow(); FIXME
		expected = null;
	}
	
	@Test
	public void testCannotTransitionateOrder() {
		State finalized = new StateBuilder().createState("Finalized").build();
		assertNotNull(sampleBusinessObject.getWorkflow());
		assertTrue(sampleBusinessObject.getWorkflow() instanceof Workflow);
		Workflow workflow = sampleBusinessObject.getWorkflow();
		List<State> states = workflow.getStates();
		State initial = workflow.getCurrentState();
		
		// real test begins here
		for(@SuppressWarnings("unused") State expected : states) {
			
			if(workflow.transitionate()) {
				// since current conditions do not satisfy required conditions, 
				// transition is not expected to take place: fire an error   
				fail("unexpected transition found!!");
			}
			
			// as such, currentState is expected to remain the same while looping over all known states
			assertTrue( workflow.getCurrentState().equals(initial) );
			
		}
		
		// once the loop finalized
		assertTrue(workflow.getCurrentState().equals(initial));
		assertFalse(workflow.getCurrentState().equals(finalized));
	}

	@Test
	public void testTransitionateOrder() {
		State finalized = new StateBuilder().createState("Finalized").build();
		
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		// this is to match expected conditions to be able to perform transitions
		((SampleWorkflowAbleObject)sampleBusinessObject).setDate(new Date()); 
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
		assertNotNull(sampleBusinessObject.getWorkflow());
		assertTrue(sampleBusinessObject.getWorkflow() instanceof Workflow);
		//sampleBusinessObject.getWorkflow().initializeWorkflow((SampleWorkflowAbleObject) sampleBusinessObject); FIXME
		Workflow workflow = sampleBusinessObject.getWorkflow();
		List<State> states = workflow.getStates();
		for(State expected : states) {
			assertTrue(expected.equals(workflow.getCurrentState())||finalized.equals(workflow.getCurrentState()));
			System.out.println("expected: "+expected);
			if(!workflow.transitionate()) {
				// if workflow couldn't transitionate, unless it reached the "finalized" state, 
				// an error has happened...
				if(!workflow.getCurrentState().equals(finalized))
					fail("expected transition didn't happen!!");
			} else {
				// since current conditions fully satisfy required conditions, 
				// transitions are expected to happen: if it didn't, we'll fire an error
				assertTrue(! expected.equals(workflow.getCurrentState()));
			}
		}
	}
}
