package ar.com.scriptorum.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mockrunner.jdbc.StatementResultSetHandler;
import com.mockrunner.mock.jdbc.MockConnection;
import com.mockrunner.mock.jdbc.MockResultSet;

public class MySqlHandlerMock extends MySqlHandler {
	
	public static StatementResultSetHandler statementHandler;
	
	@Override
	public MySqlHandlerMock connected() {
		return this;	
	}
	
	@Override
	public ResultSet read(String query) {
		MockConnection mockConnection = new MockConnection();
		statementHandler = mockConnection.getStatementResultSetHandler();
		MockResultSet set = statementHandler.createResultSet();
		statementHandler.prepareGlobalResultSet(set);
		set.addColumn("id", new Integer[] {1,2,3});
		set.addColumn("name", new String[] {"Curly","Larry","Moe"});
		try {
			mockConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}





}
