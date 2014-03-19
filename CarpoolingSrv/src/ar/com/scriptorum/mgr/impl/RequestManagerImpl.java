package ar.com.scriptorum.mgr.impl;

import java.sql.ResultSet;

import com.google.gson.Gson;

import ar.com.scriptorum.db.MySqlHandler;
import ar.com.scriptorum.mgr.RequestManager;

public class RequestManagerImpl implements RequestManager {

	static MySqlHandler handler = new MySqlHandler().connected();
	static Gson gson = new Gson();

	@Override
	public String readViajes() {
		ResultSet rs = handler.read("select * from DIAZ.VIAJES");
		return gson.toJson(rs);
		
	}

}
