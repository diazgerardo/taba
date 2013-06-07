package ar.com.scriptorum.workflow;

/**
 * Builds BusinessRules instead of Conditions
 * @author gd21367
 *
 */
public class BusinessRuleFactory {

	
	/**
	 * BusinessRule represents the same like condition but supports an associated label describing in domain 
	 * specific language what this business rule is intended to represent  
	 * @param condition
	 * @param businessRule
	 * @return a BusinessRule
	 */
	public static BusinessRule newBusinesRule(boolean condition, Integer businessRule) {
		return new BusinessRuleImpl(condition, businessRule);
	}

}
