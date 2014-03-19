package ar.com.scriptorum.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySqlHandler {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void connect() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://190.228.29.195:3306/diaz";
			connect = DriverManager.getConnection(url, "gerardo_camp","Android132134");
		} catch (Exception e) {
			throw e;
		} 
	}

	public void read(String query) throws Exception {
		try {
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			writeResultSet(resultSet);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}


	public void writeResultSet(ResultSet resultSet) throws SQLException {
		logMetadata(resultSet);
		while (resultSet.next()) {
		
			Integer id = resultSet.getInt("id");
			Integer itinerarioId = resultSet.getInt("itinerario_id");
			Integer groupId = resultSet.getInt("group_id");
			Integer vehicleId = resultSet.getInt("vehicle_id");
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