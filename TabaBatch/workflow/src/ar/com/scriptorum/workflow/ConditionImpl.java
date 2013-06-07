package ar.com.scriptorum.workflow;

public class ConditionImpl extends NullCondition implements Condition {
    Boolean condition;
   
    
    public ConditionImpl(boolean condition) {
    	this.condition = condition;
	}

	public String toString() {
    	return condition.toString();
    }
    
	@Override
    public boolean equals(Object received) {
		Condition condition = (Condition) received ;
    	return this.getValue().equals(condition.getValue());
    }
    
    @Override
    public int hashCode() {
    	return condition.toString().hashCode();
    }

	@Override
	public Boolean getValue() {
		return condition;
	}
}
