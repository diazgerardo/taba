package ar.com.scriptorum.state;

import org.junit.Test;

public class TestClientState { 
	@Test
    public void testStateContext() { 
            StateContext sc = new StateContext(); 
            sc.writeName("Monday"); 
            sc.writeName("Tuesday"); 
            sc.writeName("Wednesday"); 
            sc.writeName("Thursday"); 
            sc.writeName("Friday"); 
            sc.writeName("Saturday"); 
            sc.writeName("Sunday"); 
    }
}