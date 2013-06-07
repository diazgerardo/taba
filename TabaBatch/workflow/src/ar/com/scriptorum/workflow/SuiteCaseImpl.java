package ar.com.scriptorum.workflow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SuiteCaseImpl implements SuiteCase {
	
	private Map<Set<Condition>, State> suiteCase = Collections.synchronizedMap(new HashMap<Set<Condition>, State>());

	@Override
	public State fetch(Set<Condition> conditions) {
		return  suiteCase.get(conditions);
	}
	
	public void add(Set<Condition> key, State value) {
		this.suiteCase.put(key, value);
	}

	@Override
	public Map<Set<Condition>, State> getSuite() {
		return suiteCase;
	}
	
	
}
