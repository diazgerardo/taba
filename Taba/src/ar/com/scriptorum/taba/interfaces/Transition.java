package ar.com.scriptorum.taba.interfaces;

import java.util.Set;

import ar.com.scriptorum.taba.util.state.CustomSet;


public interface Transition {

	public State from();
	public State to();
	public CustomSet<Condition> conditions();

}
