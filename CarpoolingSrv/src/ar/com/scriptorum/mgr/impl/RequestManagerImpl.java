package ar.com.scriptorum.mgr.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.MapListHandler;

import ar.com.scriptorum.db.MySqlHandler;
import ar.com.scriptorum.mgr.RequestManager;

import com.google.gson.Gson;

public class RequestManagerImpl implements RequestManager {

	// TODO replace with real implementation
	static MySqlHandler handler = new MySqlHandler().connected();
	static Gson gson = new Gson();

	@Override
	public String readViajes() {
		List<?> list = null;
		ResultSet rs = handler.read("select * from viajes");
		MapListHandler ml = new MapListHandler(new MyRowConverter());
		try {
			list = ml.handle(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String st = gson.toJson(list);
		handler.close();
		return st; 
	}
	
	class MyRowConverter implements RowProcessor {

		@Override
		public Object[] toArray(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T toBean(ResultSet rs, Class<T> type) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> List<T> toBeanList(ResultSet rs, Class<T> type)
				throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<String, Object> toMap(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
