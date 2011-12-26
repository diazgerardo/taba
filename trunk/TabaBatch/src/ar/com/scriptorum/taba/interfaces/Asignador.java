package ar.com.scriptorum.taba.interfaces;

public interface Asignador <T> extends User {

	public boolean asignar(T t);
	public T getAsignee();
	

}
