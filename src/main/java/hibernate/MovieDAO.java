package hibernate;

public interface MovieDAO {

	public Movie getMovie(String title);
	public void printCast(String title);	
	
}
