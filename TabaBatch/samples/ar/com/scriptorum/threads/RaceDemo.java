package ar.com.scriptorum.threads;

import java.util.HashMap;

public class RaceDemo {

	private final static HashMap<Integer, Integer> priorities = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		RaceDemo raceDemo = new RaceDemo();
		System.out.println(raceDemo);
	}

	public RaceDemo() {

		priorities.put(0, Thread.MAX_PRIORITY);
		priorities.put(2, Thread.NORM_PRIORITY);
		priorities.put(1, Thread.MIN_PRIORITY);
		int processors = Runtime.getRuntime().availableProcessors();
		SelfishRunner[] runners = new SelfishRunner[processors];
		for (int i = 0; i < processors; i++) {
			runners[i] = new SelfishRunner();
			runners[i].setPriority((Integer) priorities.get(i % 3));
			runners[i].start();
		}
		try {
			Thread.currentThread();
			Thread.sleep(60000);
		} catch (InterruptedException e) {
		}
	}

}