package jdbc;

import java.time.Year;
import java.util.Set;

public class Movie {

	private int id;
	private String title;
	private Year year;
	private int number;
	private String type;
	private String location;
	private String language;
	private Set<Genre> genres;
	private Set<Aka_title> aka_titles;

	public Movie() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void addGengre(Genre genre){
		genres.add(genre);
	}
	
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Aka_title> getAka_titles() {
		return aka_titles;
	}
	
	public void addAka_title(Aka_title aka_title){
		aka_titles.add(aka_title);
	}

	public void setAka_titles(Set<Aka_title> aka_titles) {
		this.aka_titles = aka_titles;
	}

	
	//Debugging String maybe?
	public void printMovieObject(){
		System.out.format("%10d%60s%15s%15s%20s%20s%20s", id, title, year.toString(), number, type,location,language);
		System.out.print("\n");
	}

}
