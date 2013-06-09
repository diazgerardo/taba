package ar.com.scriptorum.taba.beans;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String id;
	private String name;
	private List<Address> addresses;
	
	public Customer(String id, String name){
		this.id = id;
		this.name = name;
		this.addresses = new ArrayList<Address>();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}	
}