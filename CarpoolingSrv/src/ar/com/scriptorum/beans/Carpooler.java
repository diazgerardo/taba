package ar.com.scriptorum.beans;


/**
 * source : www.javabeat.net
 */
public class Carpooler implements PersistentEntity {

	private static final long serialVersionUID = -7460746969529717870L;
	private long id;
	private String nombre;
	private String dni;
	private String telefono;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		return  "["+
				" Id:"+this.getId()+
				", Dni:"+this.getDni()+
				", Nombre"+this.getNombre()+
				", Telefono"+this.getTelefono()+
				"]";
		
	}
	}