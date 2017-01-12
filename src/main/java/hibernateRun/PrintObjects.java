package hibernateRun;

import hibernate.Aka_title;
import hibernate.Genre;
import hibernate.Movie;
import hibernate.Actor;
import hibernate.Aka_name;

public class PrintObjects {

	public static void printActorObject(Actor actor) {
		System.out.format("%10d%20s%15s%30s%20s%15d", actor.getId(), actor.getFname(), actor.getLname(),
				actor.getMname(), actor.getGender(), actor.getNumber());
		System.out.print("\n");
	}

	public static void printAka_nameObject(Aka_name aka_name) {
		System.out.format("%10d%60s", aka_name.getId(), aka_name.getName());
		System.out.print("\n");
	}

	public static void printAka_titleObject(Aka_title aka_title) {
		System.out.format("%10d%60s%15s%20s", aka_title.getId(), aka_title.getTitle(), aka_title.getYear(),
				aka_title.getLocation());
		System.out.print("\n");
	}

	public static void printGenreObject(Genre genre) {
		System.out.format("%10d%60s", genre.getId(), genre.getGenre());
		System.out.print("\n");
	}

	public static void printMovieObject(Movie movie) {
		System.out.format("%10d%60s%15s%15d%20s%20s", movie.getId(), movie.getTitle(), movie.getYear(),
				movie.getNumber(), movie.getLocation(), movie.getLanguage());
		System.out.print("\n");
	}

}
