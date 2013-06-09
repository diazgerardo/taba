package ar.com.scriptorum.workflow;

import org.springframework.expression.EvaluationContext;

public interface ContextCondition extends Condition {
	
	void eval(EvaluationContext t);

}
