package ar.com.scriptorum.concurrence;

import java.util.ArrayList;

public class Store {

	private ArrayList<Object> store = new ArrayList<Object>();

	public boolean push(Object o) {
		synchronized (store) {
			try {
				if (store.size() > 10)
					store.wait();
				store.add(o);
				return true;
			} catch (Exception e) {
				return false;
			}

		}
	}

	public Object pop() {
		synchronized (store) {

			try {
				while (store.size() < 1) {
					store.wait();
				}
				Object o = store.iterator().next();
				store.remove(o);
				store.notifyAll();
				return o;
			} catch (Exception e) {
				return null;
			}
		}
	}

	public Integer stock() {
		return store.size();
	}

}
