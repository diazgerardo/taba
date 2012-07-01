package ar.com.scriptorum.predicates;

public class BooleanPredicate extends Predicate {

	Boolean value;
	
	public BooleanPredicate(Boolean value) {
		this.value = value;
	}
	
	public BooleanPredicate eval(Boolean b) {
		
		return this;
	}
}
