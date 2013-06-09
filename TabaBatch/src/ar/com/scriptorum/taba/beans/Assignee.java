package ar.com.scriptorum.taba.beans;

public class Assignee {

	private String name;

	public Assignee(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public boolean equals(Object object){
		
		if (!(object instanceof Assignee)){
			return false;
		}
		
		Assignee incomingObject = (Assignee)object;
		return incomingObject.name.equals(name);
	}
	
	public int hashCode(){
		return 1212 + name.hashCode();
	}
	
	public String toString(){
		return name;
	}
}
