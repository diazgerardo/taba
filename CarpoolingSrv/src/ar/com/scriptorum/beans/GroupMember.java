package ar.com.scriptorum.beans;

import java.util.Date;

public class GroupMember implements PersistentEntity {

	private static final long serialVersionUID = 7696952125615864665L;
	private long id;
	private Carpooler carpooler;
	private Group group;
	private Date fecha;
	
	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id=id;
	}

	public Carpooler getCarpooler() {
		return carpooler;
	}

	public void setCarpooler(Carpooler carpooler) {
		this.carpooler = carpooler;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
