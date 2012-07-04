package ar.com.scriptorum.predicates;

public class DTO {
	int i;
	String name;
	String gender; 
	Object state;
	
	public DTO(int i, String name, String gender, Object state) {
		this.i = i;
		this.name=name;
		this.gender = gender;
		this.state = state;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Object getState() {
		return state;
	}

	public void setState(Object state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "I: "+getI() + " Name: " + getName() + " Gender: " + getGender() + " State: "+getState();
	}
}
