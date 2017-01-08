package TI2506_Group061.MovieDatabaseConnector;

import java.util.Scanner;

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

	private static Scanner inputReader = new Scanner(System.in);

	public static void main(String[] argv) {
		CreateMenu();
	}

	public static void CreateMenu() {

		System.out.println("Please select from the following options:");
		System.out.println("	(1) Search for an Actor");
		System.out.println("	(2) Search for a Movie");
		System.out.println("	(3) Search for the filmography of an Actor");
		System.out.println("	(4) Search for the cast of a Movie");
		System.out.println("	(5) Exit");

		System.out.print("Enter your choice: ");

		int option = Integer.parseInt(inputReader.nextLine());

		switch (option) {
		case 1:
			System.out.println();
			System.out.print("Please enter the first name of the Actor: ");
			String fname = inputReader.nextLine();
			System.out.print("Please enter the last name of the Actor: ");
			String lname = inputReader.nextLine();

			ActorDAO actortest = new ActorDAO_Postgres();
			// Actor resultActor = actortest.getActor("Schwarzenegger",
			// "Arnold");
			Actor resultActor = actortest.getActor(fname, lname);

			if (resultActor == null) {
				System.out.println();
				System.out.println("The Actor: \"" + fname + " " + lname + "\" was not found.");
				System.out.println();
			} else {
				System.out.println();
				System.out.println("---------- Actor -----------");
				System.out.format("%10s%20s%15s%30s%20s%15s", "ID", "Fname", "Lname", " Mname", "Gender", "Number \n");
				resultActor.printActorObject();

				System.out.println();

				System.out.println("---------- Aka names -----------");
				System.out.format("%10s%60s", "ID", "Name \n");
				for (Aka_name resultAka_name : resultActor.getAka_names()) {
					resultAka_name.printAka_nameObject();
				}

				System.out.println();
			}
			CreateMenu();
			break;
		case 2:
			System.out.println();
			System.out.print("Please enter the title of the Movie: ");
			String title = inputReader.nextLine();

			MovieDAO movietest = new MovieDAO_Postgres();
			// Movie resultMovie = movietest.getMovie("A Different World");
			Movie resultMovie = movietest.getMovie(title);

			if (resultMovie == null) {
				System.out.println();
				System.out.println("The Movie: \"" + title + "\" was not found.");
				System.out.println();
			} else {

				System.out.println("---------- Movie -----------");
				System.out.format("%10s%60s%15s%15s%20s%20s%20s", "ID", "Title", "Year", " Number", "Type", "Location",
						"Language \n");
				resultMovie.printMovieObject();

				System.out.println();

				System.out.println("---------- Aka titles -----------");
				System.out.format("%10s%60s%15s%20s", "ID", "Title", "Year", "Location \n");
				for (Aka_title resultAka_title : resultMovie.getAka_titles()) {
					resultAka_title.printAka_titleObject();
				}

				System.out.println();

				System.out.println("---------- Genres -----------");
				System.out.format("%10s%60s", "ID", "Genre \n");
				for (Genre resultGenre : resultMovie.getGenres()) {
					resultGenre.printGenreObject();
				}

				System.out.println();
			}
			CreateMenu();
			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			inputReader.close();
			System.out.println("Goodbye");

			break;
		default:

			break;
		}

	}

}