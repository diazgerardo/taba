package ar.com.scriptorum.taba.util;

public abstract class SwappingBag <R, T>{
	Object holder;
	R r;
	T t;
	
	public SwappingBag(R r,T t) {
		this.r = r;
		this.t = t;
	}
	
	public R firstSwapee() {
		return r;
	}
	
	public T getSecond() {
		return t;
	}
	
	abstract SwappingBag<R,T> swap();
	
}
