package ar.com.scriptorum.workflow;

public interface Asignador <T>{

	public boolean asignar(T t);
	public T getAsignee();
	String getName();
	String getFullName();
	String getAddress();
	String getEmailAddress();
	String getSurName();
	

}
