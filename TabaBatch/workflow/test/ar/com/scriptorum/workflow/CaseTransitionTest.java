package ar.com.scriptorum.workflow;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ar.com.scriptorum.workflow.BusinessRuleFactory;
import ar.com.scriptorum.workflow.CaseTransitionImpl;
import ar.com.scriptorum.workflow.Condition;
import ar.com.scriptorum.workflow.State;
import ar.com.scriptorum.workflow.SuiteCase;
import ar.com.scriptorum.workflow.SuiteCaseImpl;
import ar.com.scriptorum.workflow.Transition;
/**
 * Shows how to setup and use a CaseTransition
 * 
 * @author GD21367
 *
 */
public class CaseTransitionTest {

	SuiteCase suiteCase;
	Transition transition;
	
	private final Integer FIRST_CONDITION = 1;
	private final Integer SECOND_CONDITION = 2;
	private final Integer DEFAULT = 3;
	@Before 
	public void setUpSuiteCase() {
		
		suiteCase = new SuiteCaseImpl();
		Set<Condition> conditionsToMatch;
		State asocciatedState;

		// 1st element of the suite
		conditionsToMatch =  new HashSet<Condition>();
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(true, FIRST_CONDITION));
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(true, SECOND_CONDITION));
		asocciatedState = new State("1stState");
		suiteCase.add(conditionsToMatch, asocciatedState);
		
		// 2nd element of the suite
		conditionsToMatch =  new HashSet<Condition>();
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(true, FIRST_CONDITION));
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(false, SECOND_CONDITION));
		asocciatedState = new State("2ndState");
		suiteCase.add(conditionsToMatch, asocciatedState);
		

		// 3rd element of the suite
		conditionsToMatch =  new HashSet<Condition>();
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(false, FIRST_CONDITION));
		conditionsToMatch.add(BusinessRuleFactory.newBusinesRule(true, SECOND_CONDITION));
		asocciatedState = new State("3rdState");
		suiteCase.add(conditionsToMatch, asocciatedState);

		State defaultCase = new State("defaultState");
		transition = new CaseTransitionImpl(suiteCase, defaultCase);
	}
	
	@Test
	public void assert1stState() {
		Set<Condition> conditions = new HashSet<Condition>();
		conditions.add(BusinessRuleFactory.newBusinesRule(true,FIRST_CONDITION));
		conditions.add(BusinessRuleFactory.newBusinesRule(true,SECOND_CONDITION));
		State result = null;
		assertTrue((result = transition.eval(conditions))!=null);
		assertTrue(new State("1stState").equals(result));
	}

	@Test
	public void assert2ndState() {
		Set<Condition> conditions = new HashSet<Condition>();
		conditions.add(BusinessRuleFactory.newBusinesRule(true, FIRST_CONDITION));
		conditions.add(BusinessRuleFactory.newBusinesRule(false,SECOND_CONDITION));
		State result = null;
		assertTrue((result = transition.eval(conditions))!=null);
		assertTrue(new State("2ndState").equals(result));
	}

	@Test
	public void assert3rdState() {
		Set<Condition> conditions = new HashSet<Condition>();
		conditions.add(BusinessRuleFactory.newBusinesRule(false, FIRST_CONDITION));
		conditions.add(BusinessRuleFactory.newBusinesRule(true, SECOND_CONDITION));
		State result = null;
		assertTrue((result = transition.eval(conditions))!=null);
		assertTrue(new State("3rdState").equals(result));
	}

	@Test
	public void assertDefaultState() {
		Set<Condition> conditions = new HashSet<Condition>();
		conditions.add(BusinessRuleFactory.newBusinesRule(true,DEFAULT));
		State result = null;
		assertTrue((result = transition.eval(conditions))!=null);
		assertTrue(new State("defaultState").equals(result));
	}

	
}
