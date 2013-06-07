package ar.com.scriptorum.workflow;

/**
 * BusinessRule represents the same like condition but supports an associated label describing in domain 
 * specific language what this business rule is intended to represent  
 * @author gd21367
 *
 */
public interface BusinessRule extends Condition {

	public Integer associatedBusinessRule();

}
