package ar.com.scriptorum.taba.util;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import ar.com.scriptorum.workflow.util.SimpleBeanResolver;

public class BeanReferencingTest {

	@Test
	public void test() {

		ExpressionParser parser = new SpelExpressionParser();
		StandardEvaluationContext context = new StandardEvaluationContext();

		SimpleBeanResolver beanResolver = new SimpleBeanResolver();
		context.setBeanResolver(beanResolver);
				
		Expression expression = null;		
		
		expression = parser.parseExpression("@string");
		String strResult = expression.getValue(context, String.class);
		System.out.println("Result is " + strResult);
		
		expression = parser.parseExpression("@float");
		Float floatResult = expression.getValue(context, Float.class);
		System.out.println("Result is " + floatResult);		
	}
}