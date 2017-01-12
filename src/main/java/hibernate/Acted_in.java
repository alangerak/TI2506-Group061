package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Acted_in.
 */
@Entity
@Table(name = "acted_in")
public class Acted_in {

	/** The id. */
	@Id
	@Column(name = "idacted_in" , unique = true)
	private int id;

	/** The movie. 
	 * 
	 * Joins on foreign key idmovies
	 * 
	 * */
	@ManyToOne
	@JoinColumn(name = "idmovies")
	private Movie movie;
	
	/** The actor. 
	 * 
	 * Joins on foreign key idactors
	 * */
	@ManyToOne
	@JoinColumn(name = "idactors")
	private Actor actor;
	
	/** The character. */
	@Column(name = "character")
	private String character;
	
	/** The billing position. */
	@Column(name = "billing_position")
	private Integer billing_position;

	public Acted_in() {
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
	 * Gets the movie.
	 *
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Sets the movie.
	 *
	 * @param movie
	 *            the new movie
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Gets the actor.
	 *
	 * @return the actor
	 */
	public Actor getActor() {
		return actor;
	}

	/**
	 * Sets the actor.
	 *
	 * @param actor
	 *            the new actor
	 */
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	/**
	 * Gets the character.
	 *
	 * @return the character
	 */
	public String getCharacter() {
		return character;
	}

	/**
	 * Sets the character.
	 *
	 * @param character
	 *            the new character
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

	/**
	 * Gets the billing position.
	 *
	 * @return the billing position
	 */
	public Integer getBilling_position() {
		return billing_position;
	}

	/**
	 * Sets the billing position.
	 *
	 * @param billing_position
	 *            the new billing position
	 */
	public void setBilling_position(Integer billing_position) {
		this.billing_position = billing_position;
	}

}
