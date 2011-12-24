package ar.com.scriptorum.taba.util.state;

public class State extends NullState {

	String state;
	
	public State(String state) {
		this.state=state;
	}
	
	public String toString() {
		return state;
	}
	
	public boolean equals(Object o) {
		if( null == o ) return false;
		if( !(o instanceof State) ) return false;
		State state = (State)o;
		return this.state.equals(state.toString());
	}
}

