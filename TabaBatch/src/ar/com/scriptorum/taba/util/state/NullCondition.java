package ar.com.scriptorum.taba.util.state;

import ar.com.scriptorum.taba.interfaces.State;

public class NullCondition implements State {
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
