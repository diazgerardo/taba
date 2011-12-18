package ar.com.scriptorum.taba.factories;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.util.state.ConditionImpl;

public class ConditionFactory {

	public static Condition newSimpleCondition(String condition) {
		return new ConditionImpl(condition);
	}

}
