package ar.com.scriptorum.taba.util.state;

public class State extends NullState {
    public State(String state) {
		this.state=state;
	}

	String state;
	
	public String toString() {
		return state;
	}
}

