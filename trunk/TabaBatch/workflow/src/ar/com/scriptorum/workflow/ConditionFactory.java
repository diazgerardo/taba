package ar.com.scriptorum.workflow;


public class ConditionFactory {

	public static Condition newSimpleCondition(Boolean condition) {
		return new ConditionImpl(condition);
	}

	public static Condition newSimpleCondition(boolean condition) {
		return new ConditionImpl(condition);
	}

}
