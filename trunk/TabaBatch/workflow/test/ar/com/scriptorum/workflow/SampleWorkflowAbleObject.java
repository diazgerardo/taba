package ar.com.scriptorum.workflow;

import java.util.Date;

import ar.com.scriptorum.workflow.Cartography;
import ar.com.scriptorum.workflow.Workflow;
import ar.com.scriptorum.workflow.WorkflowAble;

import com.citigroup.workflow.strategy.ConditionStrategy;

public class SampleWorkflowAbleObject implements WorkflowAble {

	final static Object lock = new Object(); 
	private Cartography cartography;
	private Workflow workflow;
	private Date date;
	private ConditionStrategy strategy;
	private SampleBusinessObject managedObject;
	
	public Date getDate() {
		return date;
	}

	private Long seq;
	@Override
	public Long getId() {
		return null;
	}

	@Override
	public Long getSequence() {
		return this.seq;
	}

	@Override
	public Workflow getWorkflow() {
		return workflow;
	}

	@Override
	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Object getLock() {
		return lock;
	}	

	/**
	 * @param managedObject the managedObject to set
	 */
	public void setManagedObject(SampleBusinessObject managedObject) {
		this.managedObject = managedObject;
	}

	/**
	 * @return the managedObject
	 */
	public SampleBusinessObject getManagedObject() {
		return managedObject;
	}

	@Override
	public void setManagedObject(Object object) {
		this.managedObject = (SampleBusinessObject) object;
		
	}	
}
