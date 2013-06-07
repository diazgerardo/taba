package ar.com.scriptorum.workflow;

public class State extends NullState {

	private Long id;
	private String state;
	
	public State() {
		super();
	}
	public State(String state) {
		this.state=state;
	}
	
	public String toString() {
		return state;
	}
	
	@Override
	public int hashCode() {
		return this.state.hashCode();
	}
	
	public boolean equals(Object o) {
		if( null == o ) return false;
		if( !(o instanceof State) ) return false;
		State state = (State)o;
		return this.state.equals(state.toString());
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}

