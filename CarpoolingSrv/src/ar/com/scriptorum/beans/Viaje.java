package ar.com.scriptorum.beans;

import java.util.Date;

public class Viaje implements PersistentEntity {
	private static final long serialVersionUID = -4123935051829629650L;
	private long id;
	private Group group;
	private Boolean cerrado;
	private Date inicio;
	private Date fin;
	private Itinerario itinerario;
	private Vehiculo vehiculo;
	
	@Override
	public long getId() {
	return id;
	}
	@Override
	public void setId(long id) {
		this.id=id;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Itinerario getItinerario() {
		return itinerario;
	}
	public void setItinerario(Itinerario itinerario) {
		this.itinerario = itinerario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Boolean getCerrado() {
		return cerrado;
	}
	public void setCerrado(Boolean cerrado) {
		this.cerrado = cerrado;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	

}
