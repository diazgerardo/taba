package ar.com.scriptorum.workflow;

public class StateBuilder {

	State state;
	
	public StateBuilder createState(String state) {
		this.state = new State(state);
		return this;
	}
	
	public State build() {
		return state;
	}
}
