package ar.com.scriptorum.taba.main;

import java.sql.Date;
import java.sql.Timestamp;

public class Test2 {

	public static void main(String [] args) {
		Date date = new Date(25000000000L);
		Timestamp ts = (Timestamp)((java.util.Date) date);
	}
}
