package com.citigroup.gerardo.threads;

class SelfishRunner extends MyRunner {

	public SelfishRunner() {
	}

	public void run() {
		
		// What? A common token? What's that for? I don't care. I just tick. 
		while (tick < 400000000) {
			tick++;
			if ((tick % 500) == 0) {
				System.out.println("T #" + Thread.currentThread().getName() 	+ ", prior: " + Thread.currentThread().getPriority() + ", tick:" + tick);
			}
		}
		System.out.println("I ended myself. You just wait for the other suckers.");
	}
}
