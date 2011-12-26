package ar.com.scriptorum.taba.util.documents;

import ar.com.scriptorum.taba.interfaces.Workflow;

public abstract class AbstractDocument {
	
	private Workflow<AbstractDocument> workflow;
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
	
	public Workflow<AbstractDocument> getWorkflow() {
		return workflow;
	}
	public void setWorkflow(Workflow<AbstractDocument> workflow) {
		this.workflow = workflow;
	}

	abstract void accept(DocumentVisitor v);
}
