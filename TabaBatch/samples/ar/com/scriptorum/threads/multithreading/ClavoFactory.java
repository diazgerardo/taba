package ar.com.scriptorum.threads.multithreading;

import java.util.ArrayList;

public class ClavoFactory implements Runnable {

	protected static ArrayList<Clavo> clavos = new ArrayList<Clavo>();
	private static ClavoFactory _instance;
	static int serial = 0;
	protected static Clavo clavo;
	private ClavoFactory() {
	}

	public static ClavoFactory getInstance() {
		if (_instance == null){
			_instance = new ClavoFactory();
			new Thread(_instance).start();
		}
		return _instance;
	}

	public Clavo getNewClavo() throws InterruptedException {

		int i = clavos.size();
		if(i!=0) { 
			Clavo c = clavos.get(i-1);
			clavos.remove(i-1);
			return c;
		} else
			return null;
	}


	@Override
	public void run() {
		while(true) {
			System.out.println("**************************************************");
			System.out.println("Thread Clavo Factory: "+Thread.currentThread().getName());
			System.out.println("clavos.size(): "+clavos.size());
			System.out.println("**************************************************");
			if(clavos.size()<10000) {
				new Thread(new ClavoBuilder()).start();
			}else {
				
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
