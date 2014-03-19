package ar.com.scriptorum.db;

import static org.junit.Assert.fail;

import org.junit.Test;

public class MySqlGHandlerTest {
	
	static MySqlHandler h = new MySqlHandler();
	
	@Test
	public void readDatabase() {
		try {
			h.readDataBase();
		} catch(Exception e) {
			fail("unexpected exception="+e);
		}
	}

}
