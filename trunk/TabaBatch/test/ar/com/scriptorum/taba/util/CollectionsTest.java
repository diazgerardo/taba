package ar.com.scriptorum.taba.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.taba.beans.Address;
import ar.com.scriptorum.taba.beans.AddressType;
import ar.com.scriptorum.taba.beans.Assignee;
import ar.com.scriptorum.taba.beans.Customer;
import ar.com.scriptorum.taba.beans.DTSystem;
import ar.com.scriptorum.taba.beans.Defect;
import ar.com.scriptorum.taba.beans.Release;

public class CollectionsTest {

	@Test
	public void testCollections(){

		ExpressionParser parser = new SpelExpressionParser();
		
		Customer customer = new Customer("JHN", "John");
		
		Address homeAddress = new Address("Home Address", AddressType.HOME);
		Address billingAddress = new Address("Billing Address", AddressType.BILLING);
		
		customer.getAddresses().add(homeAddress);
		customer.getAddresses().add(billingAddress);
		
		EvaluationContext context = new StandardEvaluationContext(customer);
		Expression expression = null;
		
		expression = parser.parseExpression("name");		
		String customerName = expression.getValue(context, String.class);
		System.out.println("Customer name is " + customerName);
		
		expression = parser.parseExpression("addresses[1].addressType");
		AddressType addressType = expression.getValue(context, AddressType.class);
		System.out.println("Address Type is " + addressType);		
	}

	@Test
	public void testMap(){

		Map<String, Customer> customersMap = new HashMap<String, Customer>();
		
		Customer customer = null;
		
		customer = new Customer("JHN", "John");
		customersMap.put("JHN", customer);
		customer.getAddresses().add(new Address("Billing Address", AddressType.BILLING));
		
		customer = new Customer("JOH", "Johan");
		customersMap.put("JOH", customer);

		customer = new Customer("DVD", "David");
		customersMap.put("DVD", customer);
		
		EvaluationContext context = new StandardEvaluationContext(customersMap);

		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = null;
		
		expression = parser.parseExpression("['DVD'].name");
		String customerName = expression.getValue(context, String.class);
		System.out.println("Customer name is " + customerName);
				
		expression = parser.parseExpression("['JHN'].addresses[0].address.length()");
		Integer addressLength = expression.getValue(context, Integer.class);
		System.out.println("Address length is " + addressLength);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSelection(){

		ExpressionParser parser = new SpelExpressionParser();
				
		DTSystem system = getDTSystem();
		EvaluationContext context = new StandardEvaluationContext(system);
		Expression expression = null;
			
		String expressionStr = "Defects.?[forWhichRelease.equals(new ar.com.scriptorum.taba.beans.Release('1.0'))]";
		expression = parser.parseExpression(expressionStr);
		List<Defect> allDefectsForRelease1_0 = expression.getValue(context, List.class);
		System.out.println("Defects for 1.0 Release....");
		for (Defect defect : allDefectsForRelease1_0){
			System.out.println(defect);
		}		
	
		expressionStr = 
			"Defects.?[forWhichRelease.equals(new ar.com.scriptorum.taba.beans.Release('2.0')) " + 
				" and assignee.equals(new ar.com.scriptorum.taba.beans.Assignee('Assignee1'))]";
		expression = parser.parseExpression(expressionStr);
		List<Defect> allDefectsForRelease2_0AndAssignee1 = expression.getValue(context, List.class);
		System.out.println("Defects assigned for Assignee1 for 2.0 Release....");
		for (Defect defect : allDefectsForRelease2_0AndAssignee1){
			System.out.println(defect);
		}				
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testProjection(){

		ExpressionParser parser = new SpelExpressionParser();
				
		DTSystem system = getDTSystem();
		EvaluationContext context = new StandardEvaluationContext(system);
		Expression expression = null;
			
		String expressionStr = "Defects.![forWhichRelease]";
		expression = parser.parseExpression(expressionStr);
		List<Release> allReleases = new ArrayList<Release>(new HashSet<Release>(expression.getValue(context, List.class)));
		System.out.println("All Releases....");
		for (Release release : allReleases){
			System.out.println(release);
		}		
	
		System.out.println();
		expressionStr = "Defects.![assignee]";
		expression = parser.parseExpression(expressionStr);
		List<Assignee> allAssignees = new ArrayList<Assignee>(new HashSet<Assignee>(expression.getValue(context, List.class)));
		System.out.println("All Assignees....");
		for (Assignee assignee : allAssignees){
			System.out.println(assignee);
		}				
	}

	
	
	private DTSystem getDTSystem(){
		
		DTSystem system = new DTSystem();
		
		Release release1 = new Release("1.0");
		Release release2 = new Release("2.0");
		
		Assignee assignee1 = new Assignee("Assignee1");
		Assignee assignee2 = new Assignee("Assignee2");
		
		Defect defect1 = new Defect("1", "Defect'1'", assignee1, release2);
		system.addDefect(defect1);
		
		Defect defect2 = new Defect("2", "Defect'2'", assignee2, release1);
		system.addDefect(defect2);
		
		Defect defect3 = new Defect("3", "Defect'3'", assignee1, release2);
		system.addDefect(defect3);
		
		Defect defect4 = new Defect("4", "Defect'4'", assignee2, release1);
		system.addDefect(defect4);
		
		Defect defect5 = new Defect("5", "Defect'5'", assignee1, release2);
		system.addDefect(defect5);
		
		return system;
	}
}
