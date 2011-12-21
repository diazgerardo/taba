package ar.com.scriptorum.taba.interfaces;

import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.State;


public interface Transition {

	public State from();
	public State to();
	public CustomSet<Condition> conditions();

}
