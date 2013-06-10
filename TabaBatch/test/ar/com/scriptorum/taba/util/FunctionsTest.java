package ar.com.scriptorum.taba.util;

import java.lang.reflect.Method;
import java.util.Collection;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.workflow.util.CollectionUtils;
import ar.com.scriptorum.workflow.util.MathUtils;

/**
 * @See http://www.javabeat.net/2011/02/introduction-to-spring-expression-language-spel/
 */
public class FunctionsTest {

	@Test
	public void test() throws Exception {
		
		ExpressionParser parser = new SpelExpressionParser();
		
		StandardEvaluationContext context = new StandardEvaluationContext();
		Method method = null;
		Expression expression = null;
		Boolean value = null;
		
		// Register the method isPrime()
		method = MathUtils.class.getMethod("isPrime", Integer.class);
		context.registerFunction("prime", method);
		
		expression = parser.parseExpression("#prime(10)");
		value = expression.getValue(context, Boolean.class);
		System.out.println("Number 10 is prime: " + value);

		expression = parser.parseExpression("#prime(37)");
		value = expression.getValue(context, Boolean.class);
		System.out.println("Number 37 is prime: " + value);

		// Register the method maxElement()
		method = CollectionUtils.class.getMethod("maxElement", Collection.class);
		context.registerFunction("max", method);

		expression = parser.parseExpression("#max({10, 43, 45, 98, 32, 1})");
		Integer maxElement = expression.getValue(context, Integer.class);
		System.out.println("Max element in the list is : " + maxElement);
	}
}
