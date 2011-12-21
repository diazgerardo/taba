package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.Condition;

public class ConditionImpl extends NullCondition implements Condition {
    String condition;
    public ConditionImpl(String condition) {
    	this.condition = condition;
    }
    
    public String toString() {
    	return condition;
    }
    
    @Override 
    public boolean equals(Object o) {
    	// analize whether this particular condition has been satisfied or not
    	return this.equals(o);
    }
    
    @Override
    public int hashCode() {
    	return super.hashCode();
    }
}
