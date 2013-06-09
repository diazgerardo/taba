package ar.com.scriptorum.workflow.util;

import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

public class SimpleBeanResolver implements BeanResolver {

	@Override
	public Object resolve(EvaluationContext context, String param) throws AccessException {
		
		if (param.equals("string")){
			return new String("TEST");
		}else if (param.equals("integer")){
			return new Integer(100);
		}else if (param.equals("float")){
			return new Float(10.34);
		}else{
			return null;
		}
	}

}
