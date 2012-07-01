package ar.com.scriptorum.concurrence;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

/**
 * 
 * This test is prepared to demonstrate how thread.start() and thread.join() work together to parallelize a task
 * 
 * Proceed as follows: 
 *	
 *	1) First, go through the code, read it, try to guess what will this code do when running
 * 	2) Then, run only testWithoutJoin(), look at the results
 *	3) After that, run testWithJoin(), look at the results too
 *	4) Finally, run all the tests together several times, then compare the results you got each time
 *	with what you expected to happen before running
 *
 *	Comments/questions/sugerences are welcome, just drop me an email to gerardo@scriptorum.com.ar
 * 
 * @author gerardo
 *
 */

public class ForemanTest {
	
	static int numberOfThreads = 20;
	static Thread threads [] = new Thread[numberOfThreads];
	static AtomicInteger haveWorked = new AtomicInteger();
	
	@Test
	public void testWithoutJoin() {
		startWorking("WithoutJoin");
		evalResults();
	}

	@Test
	public void testWithJoin() {
		startWorking("WithJoin");
		startWaiting();
		evalResults();
	}

	private void evalResults() {
		if(haveWorked.get() < numberOfThreads) {
			System.out.println("What a bunch of lazy workers! Only " + haveWorked.get() + " got your job done!");
		} else if(haveWorked.get()==numberOfThreads) {
			System.out.println("Very well workers, all of you (" + haveWorked.get() + " guys) got your job done before I got to leave!");
		} else { // haveWorked.get() > numberOfThreads) 
			System.out.println("Come on suckers, you're lying to me (I didn't hire " + haveWorked.get() + " guys!)");
		}
	}
	
	public void startWorking(String string) {
		for(int i = 0; i < numberOfThreads; i++) {
			threads[i] = new Thread(new Worker(string+i));
			threads[i].start();
		}
	}
	
	public void startWaiting() {
		for(int i = 0; i < numberOfThreads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// this code is not expected to run
				System.out.println("can't wait anymore;");
			}
		}
	}
	
	public class Worker implements Runnable {
		
		private String wrkId;
		
		public Worker(String wrkId) {
			this.wrkId = wrkId;
		}
		
		@Override
		public void run() {
			try {
				long waitingTime = new Random().nextInt(10000)+1; 
				System.out.println("Worker " 
						+ this.wrkId + " esperará " + waitingTime + " millis antes de terminar.");
				Thread.sleep(waitingTime);
				System.out.println("Worker " 
						+ this.wrkId + " terminó de esperar luego de " + waitingTime + " millis.");
				haveWorked.getAndAdd(1);
			
			} catch (InterruptedException e) {
				// this code is not expected to run 
				System.out.println("Worker " + this.wrkId + " ha sido interrumpido!");
			}
		}
	}
}
