package ar.com.scriptorum.taba.beans;


public class Defect {

	private String id;
	private String description;
	private Assignee assignee;
	private Release forWhichRelease;
	
	public Defect(String id, String description, Assignee assignee, Release forWhichRelease){
		this.id = id;
		this.description = description;
		this.assignee = assignee;
		this.forWhichRelease = forWhichRelease;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Assignee getAssignee() {
		return assignee;
	}
	
	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}

	public Release getForWhichRelease() {
		return forWhichRelease;
	}

	public void setForWhichRelease(Release forWhichRelease) {
		this.forWhichRelease = forWhichRelease;
	}	

	public boolean equals(Object object){
		
		if (!(object instanceof Defect)){
			return false;
		}
		
		Defect incomingDefect = (Defect)object;
		return incomingDefect.id == id;
	}
	
	public int hashCode(){
		return 133232 + id.hashCode();
	}
	
	public String toString(){
		return id + "-" + description + "-" + assignee + "-" + forWhichRelease;
	}
}