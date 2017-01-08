package jdbc;

public interface ActorDAO {

	public Actor getActor(String lname, String fname);
	public void printFilmography(String lname, String fname);
	
}
