package TI2506_Group061.MovieDatabaseConnector;

import vanilla.Movie;
import vanilla.MovieDAO;
import vanilla.MovieDAO_Postgres;

public class App {

	public static void main(String[] argv) {

		MovieDAO movietest = new MovieDAO_Postgres();
		Movie resultMovie = movietest.getMovie("Blade");
		
		System.out.format("%10s%60s%15s%15s%20s%20s%20s", "ID", "Title", "Year", " Number", "Type","Location","Language \n");
		resultMovie.printMovieObject();
		
	}

}