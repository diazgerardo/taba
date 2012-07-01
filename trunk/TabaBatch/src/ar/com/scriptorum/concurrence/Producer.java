package ar.com.scriptorum.concurrence;

public class Producer implements Runnable {

	private Store store;

	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		Object o = new Object();
		store.push(o);
		System.out.println(Thread.currentThread().getName() + " - >push("+o.hashCode()+")" );
	}
}