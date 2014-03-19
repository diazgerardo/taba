package ar.com.scriptorum.mgr.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.MapListHandler;

import ar.com.scriptorum.db.MySqlHandler;
import ar.com.scriptorum.db.MySqlHandlerMock;
import ar.com.scriptorum.mgr.RequestManager;

import com.google.gson.Gson;

public class RequestManagerImpl implements RequestManager {

	// TODO replace with real implementation
	static MySqlHandler handler = new MySqlHandlerMock().connected();
	static Gson gson = new Gson();

	@Override
	public String readViajes() {
		List list = null;
		ResultSet rs = handler.read("select * from DIAZ.VIAJES");
		MapListHandler ml = new MapListHandler();
		try {
			list = ml.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String st = gson.toJson(list);
		
		return st; 
	}

}
