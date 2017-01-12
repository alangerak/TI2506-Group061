package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Aka_title.
 */
@Entity
@Table(name = "aka_titles")
public class Aka_title {

	/** The id. */
	@Id
	@Column(name = "idaka_titles" , unique = true)
	private int id;
	
	/** The title. */
	@Column(name = "title")	
	private String title;

	/** The location. */
	@Column(name = "location")	
	private String location;

	/** The year. */
	@Column(name = "year")	
	private Integer year;
	
	/** The movie. 
	 * 
	 * Joins on foreign key idmovies
	 * */
	@ManyToOne
	@JoinColumn(name = "idmovies")
	private Movie movie;

	public Aka_title() {
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

}
