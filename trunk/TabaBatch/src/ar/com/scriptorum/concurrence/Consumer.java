package ar.com.scriptorum.concurrence;

public class Consumer implements Runnable {

	private Store store;
	
	public Consumer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " - <-pop(" + store.pop().hashCode()+")");
	}
}
