package ar.com.scriptorum.workflow;

public class BusinessRuleImpl extends NullCondition implements BusinessRule {
    Boolean condition;
    Integer associatedBusinessRule;
       
    
    public BusinessRuleImpl(){};
    
    public BusinessRuleImpl(boolean condition, Integer businessRule) {
    	this.condition = condition;
    	this.associatedBusinessRule = businessRule;
	}

	public String toString() {
    	return "className:"+this.getClass().getSimpleName()+" associatedBusinessRule: "+associatedBusinessRule()+" condition:"+condition.toString();
    }
    
	@Override
    public boolean equals(Object received) {
		if(received instanceof BusinessRuleImpl){
			BusinessRuleImpl objToCOmpare = (BusinessRuleImpl) received;
			if(objToCOmpare.associatedBusinessRule().equals(this.associatedBusinessRule) && objToCOmpare.getValue().equals(this.condition)){
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		
		}
    }
    
    @Override
    public int hashCode() {
    	return condition.toString().hashCode();
    }

	@Override
	public Boolean getValue() {
		return condition;
	}

	@Override
	public Integer associatedBusinessRule() {
		return this.associatedBusinessRule;
	}

	/**
	 * @return the condition
	 */
	public Boolean getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(Boolean condition) {
		this.condition = condition;
	}

	/**
	 * @return the associatedBusinessRule
	 */
	public Integer getAssociatedBusinessRule() {
		return associatedBusinessRule;
	}

	/**
	 * @param associatedBusinessRule the associatedBusinessRule to set
	 */
	public void setAssociatedBusinessRule(Integer associatedBusinessRule) {
		this.associatedBusinessRule = associatedBusinessRule;
	}
}
