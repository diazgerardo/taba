package ar.com.scriptorum.taba.util;

import java.util.List;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @See http://www.javabeat.net/2011/02/introduction-to-spring-expression-language-spel/
 */
public class MethodAccessTest {
	
	@Test
	public void test1(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("new java.lang.String('Hello')");
		
		String stringObject = expression.getValue(String.class);
		System.out.println("String object is " + stringObject);		
	}

	@Test
	public void test2(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Find me'.charAt(3)");
		
		Character character = expression.getValue(Character.class);
		System.out.println("Character at position 3 is " + character);		
	}	

	@Test
	public void test3(){
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("new java.util.ArrayList()");
		
		@SuppressWarnings("unchecked")
		List<String> numbers = expression.getValue(List.class);
		System.out.println("Numbers list is " + numbers);		
	}	

}
