package jdbc;

import java.time.Year;

/**
 * The Class Aka_title.
 */
public class Aka_title {

	/** The id. */
	private int id;
	
	/** The title. */
	private String title;
	
	/** The location. */
	private String location;
	
	/** The year. */
	private Year year;

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
	public Year getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year
	 *            the new year
	 */
	public void setYear(Year year) {
		this.year = year;
	}
	
	//Debugging String maybe?
	public void printAka_titleObject(){
		System.out.format("%10d%60s%15s%20s", id, title, year.toString(), location);
		System.out.print("\n");
	}

}
