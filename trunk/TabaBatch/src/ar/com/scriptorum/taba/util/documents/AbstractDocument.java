package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.interfaces.Transition;
import ar.com.scriptorum.taba.interfaces.Workflow;

public abstract class AbstractDocument {
	
	private Workflow<Transition> workflow;
	private String docName;
	private String department;
	
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String deparment) {
		this.department = deparment;
	}
	
	public Workflow<Transition> getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow<Transition> workflow) {
		this.workflow = workflow;
	}

	abstract void accept(DocumentVisitor v);
}
