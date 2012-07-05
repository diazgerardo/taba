package ar.com.scriptorum.state;

import org.apache.commons.lang.StringUtils;

class StateC implements State { 
    public void writeName(StateContext stateContext, String name){
    	    System.out.println(StringUtils.reverse(name)); 
            stateContext.setState(new StateA()); 
    }
}