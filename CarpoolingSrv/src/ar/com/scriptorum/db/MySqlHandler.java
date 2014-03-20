package ar.com.scriptorum.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import ar.com.scriptorum.exceptions.BusinessException;

public class MySqlHandler {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public MySqlHandler connected() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://190.228.29.195:3306/diaz";
			connect = DriverManager.getConnection(url, "gerardo_camp","Android132134");
		} catch (Exception e) {
			throw new BusinessException("oops. shit happens :)");
		} 
		return this;
	}

	public ResultSet read(String query) {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			writeResultSet(resultSet);
			return resultSet;
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}
	
	public void writeResultSet(ResultSet resultSet) throws SQLException {
		logMetadata(resultSet);
		while (resultSet.next()) {
		
			Integer id = resultSet.getInt("id");
			Integer itinerarioId = resultSet.getInt("itinerario_id");
			Integer groupId = resultSet.getInt("group_id");
			Integer vehicleId = resultSet.getInt("vehiculo_id");
			Boolean cerrado = resultSet.getBoolean("cerrado");
			Date inicio = resultSet.getDate("inicio");
			Date fin = resultSet.getDate("fin");
			System.out.println("          id: " + id);
			System.out.println("itinerarioId: " + itinerarioId);
			System.out.println("     groupId: " + groupId);
			System.out.println("   vehicleId: " + vehicleId);
			System.out.println("     cerrado: " + cerrado);
			System.out.println("      inicio: " + inicio);
			System.out.println("         fin: " + fin);
		}
		resultSet.beforeFirst();
	}

	public void close() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (statement != null)
				statement.close();
			if (connect != null)
				connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void logMetadata(ResultSet resultSet) throws SQLException {
		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " "
					+ resultSet.getMetaData().getColumnName(i));
		}
	}
}