package tiact.test;

import tiact.persistence.database.DatabaseConnectionFactory;

public class ProvaConnFactDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DatabaseConnectionFactory.getConnection();
		
		DatabaseConnectionFactory.shutdown();

	}

}
