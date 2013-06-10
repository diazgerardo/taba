package ar.com.scriptorum.taba.util;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.taba.beans.AddressType;
import ar.com.scriptorum.taba.beans.Customer;

/**
 * @See http://www.javabeat.net/2011/02/introduction-to-spring-expression-language-spel/
 */
public class MiscTest {

	@Test
	public void testTOperator(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("T(ar.com.scriptorum.taba.beans.Customer)");		
		Class<?> customerClassObject = expression.getValue(Class.class);
		System.out.println("Customer's class object is " + customerClassObject);				
	}
	
	@Test
	public void test2(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(
			"T(ar.com.scriptorum.taba.beans.AddressType).valueOf('HOME')");
		
		AddressType homeAddressType = expression.getValue(AddressType.class);
		System.out.println("Home address type is " + homeAddressType);		
	}

	@Test
	public void testConstructor(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(
			"new ar.com.scriptorum.taba.beans.Customer('NEW', 'New Customer')");
		
		Customer customer = expression.getValue(Customer.class);
		String customerId = customer.getId();
		System.out.println("Customer Id is " + customerId);
		
		String customerName = customer.getName();
		System.out.println("Customer name is " + customerName);
	}

	@Test
	public void testSafeNull(){
		
		ExpressionParser parser = new SpelExpressionParser();
		
		Customer customer = new Customer("TEST", "TEST");
		customer.setAddresses(null);
		
		EvaluationContext context = new StandardEvaluationContext(customer);
		
		Expression expression = parser.parseExpression("addresses?.addressType");		
		AddressType addressType = expression.getValue(context, AddressType.class);
		System.out.println("Address type is " + addressType);		
	}

}
