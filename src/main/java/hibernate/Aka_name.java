package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Aka_name.
 */
@Entity
@Table(name = "aka_names")
public class Aka_name {

	/** The id. */
	@Id
	@Column(name = "idaka_names" , unique = true)
	private int id;
	
	/** The name. */
	@Column(name = "name")
	private String name;
	
	/** The actor. 
	 * 
	 * Joins on foreign key idactors
	 * */
	@ManyToOne
	@JoinColumn(name = "idactors")
	private Actor actor;

	public Aka_name() {
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
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
