package ar.com.scriptorum.taba.util;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.taba.beans.Customer;

public class AssignmentTest {

	@Test 
	public void test() {
		
		ExpressionParser parser = new SpelExpressionParser();
		
		Customer customer = new Customer("STV", "Steve");
		EvaluationContext context = new StandardEvaluationContext(customer);
		
		Expression expression = null;
		
		expression = parser.parseExpression("name");
		String customerName = expression.getValue(context, String.class);
		System.out.println("Customer name is " + customerName);
		
		expression.setValue(context, "Stephen");
		customerName = expression.getValue(context, String.class);
		System.out.println("Customer's modified name is " + customerName);
	}
}
