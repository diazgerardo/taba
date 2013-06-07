package ar.com.scriptorum.workflow;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.citigroup.workflow.strategy.ConditionStrategy;

@Component
@Scope("prototype")
public class WorkflowImpl implements Workflow {

	private WorkflowAble target;
	private Long id;
	private State currentState;
	private Date dateModif;
	
	private Logger _logger = Logger.getLogger(WorkflowImpl.class);
	private List<Transition> workflow = Collections.synchronizedList(new LinkedList<Transition>());
	private List<State> states;
	
	private StateMachine stateMachine;	
	private ConditionStrategy strategy;	
	
	
	@Override
	public synchronized void initializeWorkflow(WorkflowAble workflowAble, CartographyFactory cartographyFactory,ConditionStrategy strategy) {
		
		this.target = workflowAble;		
		Class<?> managedObjectClass = AMTUtils.getClassForEnhancedObject(target.getManagedObject());
		_logger.info(">");		
		// Using superClass to avoid $$EnhancedCGLIB... for lazy elements
		stateMachine = new StateMachineImpl(cartographyFactory.buildCartography(managedObjectClass), currentState);
		states = stateMachine.getStates();
		currentState = stateMachine.getCurrent();
		dateModif = new Date();
		this.strategy = strategy;		
	}


	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@Override
	public WorkflowAble getTarget() {
		return target;
	}

	@Override
	public Workflow setTarget(WorkflowAble target) {
		this.target = target;
		return this;
	}

	@Override
	public List<? extends Transition> getWorkflow() {
		return this.workflow;
	}

	@Override
	public void add(Transition t) {
		throw new RuntimeException("Unsupported operation");
	}

	@Override
	public State getCurrentState() {
		return this.currentState;
	}

	@Override
	public Workflow setCurrentState(Workflow workflow) {
		if(workflow!=null)
			this.currentState = workflow.getCurrentState();
		return this;
	}

	@Override
	public Transition getLastTransition() {
		throw new RuntimeException("Unsupported operation");
	}

	@Override
	public boolean transitionate() {
		//_logger.info(">");
		State previous = this.currentState;
		//this.currentState = stateMachine.apply(conditions);
		_logger.debug("Statistics: Transitionating from: " + previous);
		this.currentState = stateMachine.apply(strategy.validate());
		_logger.debug("Statistics: Transitionated to: " + this.currentState);
		dateModif = new Date();
		return !previous.equals(this.currentState);
	}

	@Override
	public List<State> getStates() {
		return this.states;
	}

	@Override
	public Date getDateModif() {
		return this.dateModif;
	}

	@Override
	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	@Override
	public Workflow setCurrentState(State state) {
		this.currentState = state;
		return this;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("WorkflowImpl ");
		sb.append(" Id:"+this.getId());
		sb.append(" Target:"+this.getTarget());
		sb.append(" CurrentState:"+this.getCurrentState());
		sb.append(" DateModif:"+this.getDateModif());
		return sb.toString();
	}
}
