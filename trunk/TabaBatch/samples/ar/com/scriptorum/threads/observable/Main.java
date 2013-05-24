package ar.com.scriptorum.threads.observable;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.BlockingDeque;


public class Main {
	public static void main(String ... args) {
		
		Main main = new Main();
		main.run();
	}
	
	public void run() {
		BlockingDeque q=null;
		
		
		DummyObservable o = new DummyObservable(0);
		q.add(o);
		for(int i = 0; i<10;i++) {
			o.addObserver(new DummyObserver(i));
		}
		for(int i = 25;i<35;i++) {
			o.setValue(i);
		}
		
		
	}
	
	class DummyObserver implements Observer {
		Integer i = null;
		DummyObserver(Integer i){
			this.i = i;
		}

		@Override
		public void update(Observable o, Object arg) {
			DummyObservable d = (DummyObservable) o;
			System.out.println("thread"+Thread.currentThread()+"updateing " + i + " adding " + d.getValue());
			
			i=i.intValue()+d.getValue();
		}
		
	}
	
	class DummyObservable extends Observable {

		   private int n = 0;
		   public DummyObservable(int n)
		   {
		      this.n = n;
		   }
		   public void setValue(int n)
		   {
		      this.n = n;
		      setChanged();
		      notifyObservers(this);
		   }
		   public int getValue()
		   {
		      return n;
		   }
	}
	
}
