package ar.com.scriptorum.workflow;

import java.io.Serializable;
import java.util.Date;

import ar.com.scriptorum.interfaces.PersistentEntity;

public class WorkflowHist implements Serializable, PersistentEntity {

	private static final long serialVersionUID = 194235473991769145L;
	private int id;
	private Long idWorkflow;
	private String state;
	private Date date;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Long getIdWorkflow() {
		return idWorkflow;
	}
	
	public void setIdWorkflow(Long idWorkflow) {
		this.idWorkflow = idWorkflow;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
