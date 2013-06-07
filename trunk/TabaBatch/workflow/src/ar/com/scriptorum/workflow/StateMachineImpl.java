package ar.com.scriptorum.workflow;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;



public class StateMachineImpl implements StateMachine {
	
	private State current;
	private List<State> states;
	private static Logger _logger = Logger.getLogger(StateMachineImpl.class);
	private Map<State, ? extends Transition> transitions;

	public StateMachineImpl(Cartography cartography, State state) {
		if(state != null) {
			this.current = state;
		}
		else {
			this.current = cartography.getStart();
		}
		this.transitions = cartography.getValidTransitions();
		this.states = cartography.getStates();
	}		

	@Override
	public State apply(Set<Condition> conditions) {
		current = getNextState(conditions); 
		return current;
	}

	@Override
	public State getNextState(Set<Condition> conditions) {
		State state;
		try {
			state = transitions.get(current).eval(conditions);
			_logger.debug("transitions.get(current).eval(conditions):"+state);
			if((state)!= null )
				return state;
		} catch(Exception e) {
			// not found? anything else? just print stacktrace and shutup
			_logger.debug(e.getMessage());
			e.printStackTrace();
		}
		
		return current;
	}
	
	public List<State> getStates() {
		_logger.debug(states.toString());
		return states;
	}

	@Override
	public Set<Condition> getConditionsForState(State currentState) {
		Set<Condition> conditions = transitions.get(currentState).conditions(); 
		_logger.debug("transitions.get(currentState).conditions().toString():"+conditions.toString());
		return conditions;
	}

	@Override
	public State getCurrent() {
		return current;
	}

	@Override
	public void setCurrent(State current) {
		_logger.info("changed current from: "+this.current+" to: "+current);
		this.current = current;
	}
}