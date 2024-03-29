package tiact.persistence.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tiact.exception.PersistenceException;
import tiact.persistence.User;
import tiact.persistence.database.DatabaseConnectionFactory;

public class UserDAO {

	private static final String INSERT_SQL = "INSERT INTO PUBLIC.USERS VALUES('32L4K2JLIJ4O2','MAX','MAX')";
	private static final String SELECT_SQL = "SELECT allow,name FROM extension WHERE name=?";
	private static final String UPDATE_SQL = "UPDATE extension allow=? WHERE name=?";
	private static final String DELETE_SQL = "DELETE FROM extension WHERE name=?";

	private UserDAO() {
		super();
	}

	static void load(User object) throws PersistenceException {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rst = null;
		con = DatabaseConnectionFactory.getConnection();
		try {
			stm = con.prepareStatement(SELECT_SQL);
//			stm.setString(1, object.getName());
			rst = stm.executeQuery();
			rst.next();
//			object.setAllow(rst.getBoolean("allow"));
//			object.setName(rst.getString("name"));
		} catch (SQLException e) {
			throw new PersistenceException(object.toString(), e);
		} finally {
			if (rst != null)
				try {
					rst.close();
				} catch (Exception e) {
				}
			if (stm != null)
				try {
					stm.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	static void insert(User object) throws PersistenceException {
		Connection con = null;
		PreparedStatement stm = null;
		con = DatabaseConnectionFactory.getConnection();
		try {
			stm = con.prepareStatement(INSERT_SQL);
//			stm.setBoolean(1, object.isAllow());
//			stm.setString(2, object.getName());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(object.toString(), e);
		} finally {
			if (stm != null)
				try {
					stm.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	static void delete(User object) throws PersistenceException {
		Connection con = null;
		PreparedStatement stm = null;
		con = DatabaseConnectionFactory.getConnection();
		try {
			stm = con.prepareStatement(DELETE_SQL);
//			stm.setString(1, object.getName());
			System.out.println(stm);
			stm.execute();
		} catch (SQLException e) {
			throw new PersistenceException(object.toString(), e);
		} finally {
			if (stm != null)
				try {
					stm.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}

	static void update(User object) throws PersistenceException {
		Connection con = null;
		PreparedStatement stm = null;
		con = DatabaseConnectionFactory.getConnection();
		try {
			stm = con.prepareStatement(UPDATE_SQL);
//			stm.setBoolean(1, object.isAllow());
//			stm.setString(2, object.getName());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(object.toString(), e);
		} finally {
			if (stm != null)
				try {
					stm.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}
	}
}
