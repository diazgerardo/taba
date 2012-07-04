package ar.com.scriptorum.rimas.silabeo;


public class Silaba {
	
	private String value = "";

	public Silaba(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	// hidden to make Silaba inmutable
	@SuppressWarnings("unused")
	private void setValue(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value.toString();
	}

}
