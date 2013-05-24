package ar.com.scriptorum.reflection;

public class Dumb {
	
	public void dumb(Double d) {
		System.out.print(" Double ");
		say(d);
	}

	public void dumb(Integer i) {
		System.out.print(" Integer ");
		say(i);
	}

	public void dumb(Long l) {
		System.out.print(" Long ");
		say(l);
	}
	public void dumb(int i) {
		System.out.print(" int ");
		say(i);
	}

	private void say(Number n) {
		System.out.print(n+" ");
	}
}
