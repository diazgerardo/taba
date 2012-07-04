package ar.com.scriptorum.predicates;

import org.apache.commons.collections.*;

public class PrintIt implements Closure {
	// This class implements a Singleton Pattern
	private static PrintIt ourInstance = new PrintIt();

	/**
	 * Get a singleton instance of PrintIt
	 */
	public static PrintIt getInstance() {
		return ourInstance;
	}

	private PrintIt() // This is a singleton, dont change this!
	{
	}

	public void execute(Object o) {
		System.out.println(o.toString());
	}
}