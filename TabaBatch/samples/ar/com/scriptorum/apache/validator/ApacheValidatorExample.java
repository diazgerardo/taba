package ar.com.scriptorum.apache.validator;

import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.ValidatorResources;

public class ApacheValidatorExample {
	DummyClass dummyObject;
	private ApacheValidatorExample() {
		dummyObject = new DummyClass();
		Validator v = new Validator(new ValidatorResources());
		try {
			v.validate();
			System.out.println("ok!");
		} catch (ValidatorException e) {
			System.out.println("validation fails.");
		}
	}
	
	public String toString() {
		return dummyObject.toString();
	}

	public static void main(String [] arsg ) {
		ApacheValidatorExample ave = new ApacheValidatorExample();
		System.out.println(ave);
	}
	
	public class DummyClass {
	
		int i;
		int j;
		
		public int getI() {
			return i;
		}
		
		public void setI(int i) {
			this.i = i;
		}
		
		public int getJ() {
			return j;
		}
		
		public void setJ(int j) {
			this.j = j;
		}
		
		public String toString() {
			return "i: "+i+"j :"+j;
		}
	}
}
