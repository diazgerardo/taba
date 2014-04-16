package ar.com.scriptorum.beans;

import java.util.Date;
import java.util.Set;

/**
 * source : www.javabeat.net
 */
public class Group implements PersistentEntity {

	private static final long serialVersionUID = -7460746969529717870L;
	private long id;
	private String nombre;
	private Date creacion;
	private Set<GroupMember> groupMembers;
	
	public Set<GroupMember> getGroupMembers() {
		return groupMembers;
	}
	public void setGroupMembers(Set<GroupMember> groupMembers) {
		this.groupMembers = groupMembers;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	@Override
	public String toString() {
		StringBuffer members = new StringBuffer();
		members.append("{");
		for(GroupMember member: groupMembers) {
			members.append(member);
		}
		members.append("}");
		return  "["+
				" Id:"+this.getId()+
				" Nombre:"+this.getNombre()+
				" Creacion:"+this.getCreacion()+
				" Members:"+this.getGroupMembers()==null?"sin miembros aún.":members.toString()+
				"]";
	}
}
