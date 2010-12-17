package tiact.persistence.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionFactory {

	private static DatabaseConnectionFactory instance;
	private Connection connection;

	private static boolean driverLoaded = false;

	private static final String MY_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
	private static final String MY_URL_PRE = "jdbc:hsqldb:file:";
	private static final String MY_URL_POS = "db/tiactdb_dev;"; //ifexists=true;"; Allora Connettiti solo se esiste il db
	private static final String LOGIN = "SA";
	private static final String PASSWD = "";

	private DatabaseConnectionFactory() {
		try {
			if (!driverLoaded) {
				try {
					Class.forName(MY_DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				driverLoaded = true;
			}
			connection = DriverManager.getConnection(MY_URL_PRE+MY_URL_POS, LOGIN, PASSWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Questo metodo restituisce la connection per effettuare la connessione al
	 * database
	 */
	public static synchronized Connection getConnection() {
		if (instance == null)
			instance = new DatabaseConnectionFactory();
		return instance.connection;
	}
	
	public static synchronized void shutdown(){
		Connection con=null;
		Statement stm=null;
        con = DatabaseConnectionFactory.getConnection();
        try {
                stm = con.createStatement();
                stm.execute("SHUTDOWN");
        } catch (SQLException e) {
                //throw new PersistenceException(client.toString(),e);
        }
        finally {
                if (stm != null) try {stm.close();} catch (Exception e) {}
                if (con != null) try {con.close();} catch (Exception e) {}
        }
	}
}