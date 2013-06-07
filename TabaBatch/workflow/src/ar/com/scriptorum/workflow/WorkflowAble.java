package ar.com.scriptorum.workflow;




public interface WorkflowAble <T>{
	
	public Long getId();
	public Long getSequence();
	public Workflow getWorkflow();
	public void setWorkflow(Workflow workflow);
	public Object getLock();
	public Object getManagedObject();
	public void setManagedObject(Object object);
}
