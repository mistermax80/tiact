package tiact.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Prova {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Class.forName("org.hsqldb.jdbc.JDBCDriver");

		} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}
		try {
			String wd = System.getProperty("user.dir");
			Connection c = DriverManager.getConnection("jdbc:hsqldb:file:"
					+ "db/tiactdb", "SA", "");
		} catch (SQLException e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

	}

}
