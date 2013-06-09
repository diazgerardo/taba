package ar.com.scriptorum.workflow.strategy;

import java.util.Set;

import ar.com.scriptorum.workflow.Condition;
import ar.com.scriptorum.workflow.WorkflowAble;

public interface ConditionStrategy {

	Set<Condition> validate ();
	void initialize (WorkflowAble<?> t);
}
