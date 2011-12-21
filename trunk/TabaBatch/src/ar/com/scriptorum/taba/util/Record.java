package ar.com.scriptorum.taba.util;

public class Record {
	private String field1;
	private String field2;
	private String field3;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public Record(String line) {
		String[] record = line.split("-");

		this.setField1(record[0]);
		this.setField2(record[1]);

	}

	public Record() {

	}
	
	@Override
	public String toString() {
		return "Field1: "+this.getField1()+" Field2: "+this.getField2()+" Field3: "+this.getField3();
	}
}
