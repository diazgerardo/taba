package ar.com.scriptorum.taba.util;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.taba.beans.Customer;
import ar.com.scriptorum.workflow.util.SimpleBeanResolver;


public class BeanReferencingTest {

	@Test
	public void test() {

		ExpressionParser parser = new SpelExpressionParser();
		Customer cs = new Customer("gd","Gerardo Diaz");
		StandardEvaluationContext context = new StandardEvaluationContext(cs);

		SimpleBeanResolver beanResolver = new SimpleBeanResolver();
		context.setBeanResolver(beanResolver);
				
		Expression expression = null;		
		
		expression = parser.parseExpression("@string");
		String strResult = expression.getValue(context, String.class);
		System.out.println("Result is " + strResult);
		
		expression = parser.parseExpression("@float");
		Float floatResult = expression.getValue(context, Float.class);
		System.out.println("Result is " + floatResult);		
		
		expression = parser.parseExpression("@rootObject");
		Customer customer = expression.getValue(context, Customer.class);
		String customerId = customer.getId();
		System.out.println("Customer Id is " + customerId);
		
		String customerName = customer.getName();
		System.out.println("Customer name is " + customerName);
			
	}
}