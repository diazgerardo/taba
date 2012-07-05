package ar.com.scriptorum.producer_consumer;

class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		if (!valueSet) {
			System.out.println("nothing to get!");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		if (valueSet) {
			System.out.println("waiting to put!");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put: " + n);
		notify();
	}
}