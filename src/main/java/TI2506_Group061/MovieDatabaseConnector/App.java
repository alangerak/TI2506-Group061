package TI2506_Group061.MovieDatabaseConnector;

import jdbc.Actor;
import jdbc.ActorDAO;
import jdbc.ActorDAO_Postgres;
import jdbc.Movie;
import jdbc.MovieDAO;
import jdbc.MovieDAO_Postgres;

public class App {

	public static void main(String[] argv) {

		ActorDAO actortest = new ActorDAO_Postgres();
		Actor resultActor = actortest.getActor("Schwarzenegger", "Arnold");
		
		System.out.format("%10s%20s%15s%30s%20s%15s", "ID", "Fname", "Lname", " Mname", "Gender","Number \n");
		resultActor.printActorObject();
			
		System.out.println();
		
		MovieDAO movietest = new MovieDAO_Postgres();
		Movie resultMovie = movietest.getMovie("Blade");
		
		System.out.format("%10s%60s%15s%15s%20s%20s%20s", "ID", "Title", "Year", " Number", "Type","Location","Language \n");
		resultMovie.printMovieObject();
		
	}

}