package jdbc;

/**
 * The Class Genre.
 */
public class Genre {

	/** The id. */
	private int id;
	
	/** The genre. */
	private String genre;
	
	public Genre(){}
	
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
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre.
	 *
	 * @param genre
	 *            the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
