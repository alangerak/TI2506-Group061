package hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The DAOManager sets up and maintains a connection to the Postgres database
 *
 */
public class DAOManager {

	private static DAOManager instance = null;
	private static EntityManager manager = null;

	private static final EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("Hibernate.jbaIMDB");

	protected DAOManager() {
	}

	/**
	 * Get the DAOManager
	 * 
	 * @return the DAOManager
	 */
	public static DAOManager getInstance() {
		if (instance == null) {
			instance = new DAOManager();
		}
		return instance;
	}

	/**
	 * Get a manager that manages the connection to the Database. It will
	 * instantiate it only once.
	 * 
	 * @return EntityManager
	 */
	public EntityManager getDBConnection() {
		if (manager == null) {
			manager = entityManagerFactory.createEntityManager();
		}
		return manager;
	}

	/**
	 * Close the Database Connection. Use this preferably when the connection is
	 * no longer needed in the future.
	 */
	public void closeDBConnection() {
		manager.close();
		entityManagerFactory.close();
	}

}
