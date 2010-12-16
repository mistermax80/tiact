package tiact.test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneraDBDev {

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
			//String wd = System.getProperty("user.dir");
			DriverManager.getConnection("jdbc:hsqldb:file:"
					+ "db/tiactdb_dev", "SA", "");
		} catch (SQLException e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
		}

	}

}
