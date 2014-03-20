package ar.com.scriptorum.beans;

import java.io.Serializable;

public interface PersistentEntity extends Serializable {

	public long getId();
	public void setId(long id);

}
