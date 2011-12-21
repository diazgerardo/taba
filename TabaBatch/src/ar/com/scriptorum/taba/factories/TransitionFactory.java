package ar.com.scriptorum.taba.factories;

import java.util.ArrayList;
import java.util.List;

import ar.com.scriptorum.taba.interfaces.Condition;
import ar.com.scriptorum.taba.interfaces.State;
import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.util.state.CustomSet;
import ar.com.scriptorum.taba.util.state.TransitionImpl;

public class TransitionFactory {

	public static List<Transition> newSimpleTransition(State from, CustomSet<Condition> conditions, State to) {
		
		List<Transition> resultList = new ArrayList<Transition>();
		resultList.add(new TransitionImpl(from, conditions, to));
		return resultList;
		
	}

}