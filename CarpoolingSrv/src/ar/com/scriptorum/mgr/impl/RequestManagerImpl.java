package ar.com.scriptorum.mgr.impl;

import ar.com.scriptorum.db.MySqlHandler;
import ar.com.scriptorum.mgr.RequestManager;

public class RequestManagerImpl implements RequestManager {

	static MySqlHandler handler = new MySqlHandler().connected();
	
	@Override
	public void readViajes() {
	
		
		
	}

}
