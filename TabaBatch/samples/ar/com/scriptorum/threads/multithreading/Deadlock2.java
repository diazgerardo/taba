package ar.com.scriptorum.threads.multithreading;

import java.util.Timer;
import java.util.TimerTask;

public class Deadlock2 {
	static Object lock = new Object();
	  public static void main(String... args) {
		    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
		      @Override
		      public void run() {
		        System.out.println("Locking");
		        synchronized (lock) {
		          System.out.println("Locked");
		        }
		      }
		    }));
		    synchronized (lock) {
		      System.out.println("Exiting");
		      //System.exit(0);
		      exit(0, 10000);
				
		    }
		  }
	  
	  public static void exit(final int status, long maxDelayMillis) {
		    try {
		      // setup a timer, so if nice exit fails, the nasty exit happens
		      Timer timer = new Timer();
		      timer.schedule(new TimerTask() {
		        @Override
		        public void run() {
		          Runtime.getRuntime().halt(status);
		        }
		      }, maxDelayMillis);
		      // try to exit nicely
		      System.exit(status);
		      
		    } catch (Throwable ex) {
		      // exit nastily if we have a problem
		      Runtime.getRuntime().halt(status);
		    } finally {
		      // should never get here
		      Runtime.getRuntime().halt(status);
		    }
		  }
}
