package ar.com.scriptorum.taba.beans;

public class Address {

	private String address;
	private AddressType addressType;
	
	public Address(String address, AddressType addressType){
		this.address = address;
		this.addressType = addressType;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public AddressType getAddressType() {
		return addressType;
	}
	
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	
}
