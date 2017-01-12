package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Movie.
 */
@Entity
@Table(name = "movies")
public class Movie {

	/** The id. */
	@Id
	@Column(name = "idmovies" , unique = true)
	private int id;
	
	/** The title. */
	@Column(name = "title")	
	private String title;
	
	/** The year. */
	@Column(name = "year")	
	private Integer year;
	
	/** The number. */
	@Column(name = "number")	
	private Integer number;
	
	/** The type. */
	@Column(name = "type")	
	private String type;
	
	/** The location. */
	@Column(name = "location")	
	private String location;
	
	/** The language. */
	@Column(name = "language")	
	private String language;
	
	/** The genres. 
	 * 
	 * Joins with intermediate table movies_genres, handled by Genres.class
	 * */
	@ManyToMany(mappedBy="movies")
	private Set<Genre> genres;
	
	/** The aka titles. 
	 * 
	 * Joins on its primary key with table aka_titles
	 * */
	@OneToMany(mappedBy = "movie")	
	private Set<Aka_title> aka_titles;
	
	/** The acted in.
	 * 
	 * Joins on its primary key with table acted_in
	 *  */
	@OneToMany(mappedBy = "movie", fetch=FetchType.LAZY)	
	private Set<Acted_in> acted_in;
	

	public Movie() {
	}	

	/**
	 * Gets the acted in.
	 *
	 * @return the acted in
	 */
	public Set<Acted_in> getActed_in() {
		return acted_in;
	}

	/**
	 * Sets the acted in.
	 *
	 * @param acted_in
	 *            the new acted in
	 */
	public void setActed_in(Set<Acted_in> acted_in) {
		this.acted_in = acted_in;
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
	public Integer getYear(){
		return year;
	}
	
	/**
	 * Sets the year.
	 *
	 * @param year
	 *            the new year
	 */
	public void setYear(Integer year){
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
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
