package ar.com.scriptorum.concurrence;


public class Runner {

	public static void main(String[] args) {
		Store store = new Store();
		
		for (int i=0;;i++) {
			
			// just one producer ...
			new Thread(new Producer(store), "Producer(p"+i+")").start();
			
			// ... for several consumers :)
			new Thread(new Consumer(store), "Consumer(ca"+i+")").start();
			new Thread(new Consumer(store), "Consumer(cb"+i+")").start();
			new Thread(new Consumer(store), "Consumer(cc"+i+")").start();
			new Thread(new Consumer(store), "Consumer(cd"+i+")").start();
			new Thread(new Consumer(store), "Consumer(ce"+i+")").start();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("-----------------------------------------------------");
		}
	}
}
