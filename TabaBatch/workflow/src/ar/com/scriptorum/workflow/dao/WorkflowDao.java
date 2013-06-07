package ar.com.scriptorum.workflow.dao;

import java.util.ArrayList;

import ar.com.scriptorum.workflow.State;
import ar.com.scriptorum.workflow.Workflow;
import ar.com.scriptorum.workflow.WorkflowAble;

public interface WorkflowDao {

	public ArrayList<State> getStates ();
	
	public Workflow findWorkflow(WorkflowAble e);
}
