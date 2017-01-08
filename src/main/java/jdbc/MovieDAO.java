package jdbc;

/**
 * Interface that uses the Data Acces Object Pattern for connection the Movie
 * POJO with the database.
 *
 */
public interface MovieDAO {

	/**
	 * Find a movie from the database given a title. If there are multiple
	 * movies found, only a single one is returned.
	 * 
	 * @param title
	 *            the title of the target movie
	 * @return An object representing a movie, if it does not exists then it
	 *         returns null
	 */
	public Movie getMovie(String title);

	/**
	 * Display all actors(first name, last name, character name) of a given
	 * movie title
	 * 
	 * @param title
	 *            title of the target movie
	 */
	public void printCast(String title);

}
