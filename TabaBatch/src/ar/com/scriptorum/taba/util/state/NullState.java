package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.State;

public class NullState implements State {
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
