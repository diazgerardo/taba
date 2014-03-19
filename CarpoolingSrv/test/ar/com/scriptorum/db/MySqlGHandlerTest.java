package ar.com.scriptorum.db;

import static org.junit.Assert.fail;

import org.junit.Test;

public class MySqlGHandlerTest {
	
	static MySqlHandler h = new MySqlHandler();
	
	@Test
	public void readDatabase() {
		try {
			h.read("select * from DIAZ.VIAJES");
		} catch(Exception e) {
			fail("unexpected exception="+e);
		}
	}

}
