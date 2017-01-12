package hibernate;

/**
 * The Interface MovieDAO.
 */
public interface MovieDAO {

	public Movie getMovie(String title);
	public void printCast(String title);	
	
}
