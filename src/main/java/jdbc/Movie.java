package jdbc;

import java.util.Set;

/**
 * The Class Movie.
 */
public class Movie {

	/** The id. */
	private int id;
	
	/** The title. */
	private String title;
	
	/** The year. */
	private Integer year;
	
	/** The number. */
	private Integer number;

	/** The location. */
	private String location;
	
	/** The language. */
	private String language;
	
	/** The genres. */
	private Set<Genre> genres;
	
	/** The aka titles. */
	private Set<Aka_title> aka_titles;

	public Movie() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year
	 *            the new year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location
	 *            the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the genres.
	 *
	 * @return the genres
	 */
	public Set<Genre> getGenres() {
		return genres;
	}

	public void addGengre(Genre genre){
		genres.add(genre);
	}
	
	/**
	 * Sets the genres.
	 *
	 * @param genres
	 *            the new genres
	 */
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * Gets the aka titles.
	 *
	 * @return the aka titles
	 */
	public Set<Aka_title> getAka_titles() {
		return aka_titles;
	}
	
	public void addAka_title(Aka_title aka_title){
		aka_titles.add(aka_title);
	}

	/**
	 * Sets the aka titles.
	 *
	 * @param aka_titles
	 *            the new aka titles
	 */
	public void setAka_titles(Set<Aka_title> aka_titles) {
		this.aka_titles = aka_titles;
	}
}
