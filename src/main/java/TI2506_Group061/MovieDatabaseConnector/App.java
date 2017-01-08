package TI2506_Group061.MovieDatabaseConnector;

import jdbc.Actor;
import jdbc.ActorDAO;
import jdbc.ActorDAO_Postgres;
import jdbc.Aka_name;
import jdbc.Aka_title;
import jdbc.Genre;
import jdbc.Movie;
import jdbc.MovieDAO;
import jdbc.MovieDAO_Postgres;

public class App {

	public static void main(String[] argv) {

		ActorDAO actortest = new ActorDAO_Postgres();
		Actor resultActor = actortest.getActor("Schwarzenegger", "Arnold");

		System.out.println();
		System.out.println("---------- Actor -----------");
		System.out.format("%10s%20s%15s%30s%20s%15s", "ID", "Fname", "Lname", " Mname", "Gender","Number \n");
		resultActor.printActorObject();
		
		System.out.println();

		System.out.println("---------- Aka names -----------");
		System.out.format("%10s%60s", "ID", "Name \n");
		for(Aka_name resultAka_name: resultActor.getAka_names()){
			resultAka_name.printAka_nameObject();
		}
			
		System.out.println();
		
		
		
		
		MovieDAO movietest = new MovieDAO_Postgres();
		Movie resultMovie = movietest.getMovie("A Different World");

		System.out.println("---------- Movie -----------");
		System.out.format("%10s%60s%15s%15s%20s%20s%20s", "ID", "Title", "Year", " Number", "Type","Location","Language \n");
		resultMovie.printMovieObject();
		
		System.out.println();

		System.out.println("---------- Aka titles -----------");
		System.out.format("%10s%60s%15s%20s", "ID", "Title", "Year", "Location \n");
		for(Aka_title resultAka_title: resultMovie.getAka_titles()){
			resultAka_title.printAka_titleObject();
		}
		
		System.out.println();

		System.out.println("---------- Genres -----------");
		System.out.format("%10s%60s", "ID", "Genre \n");
		for(Genre resultGenre : resultMovie.getGenres()){
			resultGenre.printGenreObject();
		}
		
	}

}