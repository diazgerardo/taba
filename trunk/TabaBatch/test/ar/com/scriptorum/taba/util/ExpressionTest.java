package ar.com.scriptorum.taba.util;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @See http://www.javabeat.net/2011/02/introduction-to-spring-expression-language-spel/
 */
public class ExpressionTest {

	@Test
	public void test() {
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("'Testing Spring Expression Framework'");
		String message = (String) expression.getValue();
		System.out.println("Message is " + message);
	}
}
