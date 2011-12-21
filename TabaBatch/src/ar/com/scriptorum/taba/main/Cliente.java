package ar.com.scriptorum.taba.main;

public class Cliente implements Runnable {

	private int value, duplicatedValue;
	public Cliente(int i) {
		this.value = i;
		System.out.println("Starting " + Thread.currentThread().getName()  + " with parameter value=" + value );
	}
	@Override
	public void run() {
		for(int i = 0; i<100000;i++) {
			System.out.println("Running in " + Thread.currentThread().getName()  + "("+i+") value=" + value + " before duplication." );
			duplicatedValue = value * 2;
			value = Matematico.duplicar(value);
			if(value!= duplicatedValue)
				throw new RuntimeException("Exception in "+Thread.currentThread().getName()+"("+i+"): Expected: "+ duplicatedValue);
			System.out.println("After duplication, in " + Thread.currentThread().getName()  + "("+i+") value=" + value );
			try {
				synchronized(this) {
					wait(50);
				}
			} catch (InterruptedException e) {
			}
		}
	}
}
