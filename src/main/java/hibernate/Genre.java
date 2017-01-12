package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class Genre.
 */
@Entity
@Table(name = "genres")
public class Genre {

	/** The id. */
	@Id
	@Column(name = "idgenres" , unique = true)	
	private int id;
	
	/** The genre. */
	@Column(name = "genre")	
	private String genre;
	
	/** The movies. 
	 * 
	 * Join this relation by using the intermediate table "movies_genres"
	 * 
	 * */
	@ManyToMany
	@JoinTable(name="movies_genres", joinColumns=@JoinColumn(name="idgenres",referencedColumnName="idgenres"),
		inverseJoinColumns=@JoinColumn(name="idmovies",referencedColumnName="idmovies")
			)
	private Set<Movie> movies;
	
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
