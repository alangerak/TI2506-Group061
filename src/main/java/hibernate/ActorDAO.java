package hibernate;

/**
 * The Interface ActorDAO.
 */
public interface ActorDAO {

	public Actor getActor(String fname, String lname);
	public void printFilmography(String fname, String lname);
	
}
