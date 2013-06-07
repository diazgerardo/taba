package ar.com.scriptorum.workflow;

import java.util.Map;
import java.util.Set;


/**
 * SuiteCase is an convenient storage of states which can (must?) be randomly accessed by means
 * of their associated set of conditions
 * 
 * Please refer to CaseTransition for more details
 * @author GD21367
 *
 */
public interface SuiteCase {

	State fetch(Set<Condition> conditions);
	void add(Set<Condition> key, State value);
	Map<Set<Condition>, State> getSuite();
}
