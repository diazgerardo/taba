package com.scriptorum.abstractions;

import java.util.LinkedList;

public abstract class Grafo extends LinkedList<Vertice> {

	private static final long serialVersionUID = -3787876308648847767L;

	abstract void update();
	
}
