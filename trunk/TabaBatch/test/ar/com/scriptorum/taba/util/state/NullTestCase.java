package ar.com.scriptorum.taba.util.state;

import junit.framework.TestCase;
import ar.com.scriptorum.taba.interfaces.Condition;

public class NullTestCase extends TestCase {
	
	public void testNullCondition() {
		ConditionImpl nullCondition = null;
		Condition nonNullCondition = (Condition) nullCondition;
		assertNotNull(nonNullCondition);
	}

}
