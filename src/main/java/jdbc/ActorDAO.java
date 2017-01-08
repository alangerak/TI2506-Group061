package jdbc;

public interface ActorDAO {

	public Actor getActor(String fname, String lname);
	public void printFilmography(String lname, String fname);
	
}
