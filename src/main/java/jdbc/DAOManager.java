package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DAOManager sets up and maintains a connection to the Postgres database
 *
 */
public class DAOManager {

	private final String DB_DRIVER = "org.postgresql.Driver";
	private final String DB_CONNECTION = "jdbc:postgresql://localhost:5433/imdb";
	private final String DB_USER = "postgres";
	private final String DB_PASSWORD = "password";

	private static DAOManager instance = null;
	private Connection dbConnection = null;

	protected DAOManager() {
	}

	/**
	 * Get the DAOManager
	 * @return the DAOManager
	 */
	public static DAOManager getInstance() {
		if (instance == null) {
			instance = new DAOManager();
		}
		return instance;
	}

	/**
	 * Get a connection to the Database. It will instantiate it only once.
	 * @return Connection
	 */
	public Connection getDBConnection() {
		if (dbConnection == null) {
			System.out.println("..... PostgreSQL JDBC setting up connection .... ");

			System.out.print("DB Driver loading");
			try {
				Class.forName(DB_DRIVER);
				System.out.print("\t\t [OK] \n");
			} catch (ClassNotFoundException e) {
				System.out.print("\t\t [Failed] \n");
				// e.printStackTrace();
			}

			System.out.print("Connecting to DB");
			try {
				dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
				System.out.print("\t\t [OK] \n");
				return dbConnection;
			} catch (SQLException e) {
				System.out.print("\t\t [Failed] \n");
				// e.printStackTrace();

			}
		}
		return dbConnection;
	}

}
