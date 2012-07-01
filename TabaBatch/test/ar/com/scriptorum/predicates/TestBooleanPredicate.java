package ar.com.scriptorum.predicates;

import org.junit.Test;

public class TestBooleanPredicate {

	@Test
	public void test() {
		new BooleanPredicate(true).eval(false);
	}
	
}
