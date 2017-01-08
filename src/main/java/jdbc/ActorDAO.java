package jdbc;

/**
 * Interface that uses the Data Acces Object Pattern for connection the Actor
 * POJO with the database.
 *
 */
public interface ActorDAO {

	/**
	 * Find an actor from the database given the first and last name. If there
	 * are multiple actors found, only a single one is returned.
	 * 
	 * @param fname
	 *            first name of the target actor
	 * @param lname
	 *            last name of the target actor
	 * @return An object representing an actor, if it does not exists then it
	 *         returns null
	 */
	public Actor getActor(String fname, String lname);

	/**
	 * Display all movies(year, title) of an actor.
	 * 
	 * @param fname
	 *            first name of the target actor
	 * @param lname
	 *            last name of the target actor 
	 */
	public void printFilmography(String fname, String lname);

}
