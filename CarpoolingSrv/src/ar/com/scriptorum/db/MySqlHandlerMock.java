package ar.com.scriptorum.db;

import java.sql.ResultSet;

import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;

public class MySqlHandlerMock extends MySqlHandler {
	
	@Override
	public MySqlHandlerMock connected() {
		return this;	
	}
	
	@Override
	public ResultSet read(String query) {
		StatementResultSetHandler statementHandler = new MockConnection().getStatementResultSetHandler();
		MockResultSet set = statementHandler.createResultSet();
		statementHandler.prepareGlobalResultSet(set);
		set.addColumn("id", new Integer[] {1,2,3});
		set.addColumn("name", new String[] {"Curly","Larry","Moe"});
		return set;
	}





}
