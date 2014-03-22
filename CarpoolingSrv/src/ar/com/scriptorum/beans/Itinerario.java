package ar.com.scriptorum.beans;


/**
 * source : www.javabeat.net
 */
public class Itinerario implements PersistentEntity {

	private static final long serialVersionUID = -7460746969529717870L;
	private long id;
	private int googleMapId;
	private String descripcion;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getGoogleMapId() {
		return googleMapId;
	}
	public void setGoogleMapId(int googleMapId) {
		this.googleMapId = googleMapId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "["+this.getId()+
				" "+this.getDescripcion()+
				" "+this.getGoogleMapId()+
				"]";
	}
}
