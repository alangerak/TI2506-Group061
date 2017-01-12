package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acted_in")
public class Acted_in {

	@Id
	@Column(name = "idacted_in" , unique = true)
	private int id;

	@ManyToOne
	@JoinColumn(name = "idmovies")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "idactors")
	private Actor actor;
	
	@Column(name = "character")
	private String character;
	
	@Column(name = "billing_position")
	private int billing_position;

	public Acted_in() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getBilling_position() {
		return billing_position;
	}

	public void setBilling_position(int billing_position) {
		this.billing_position = billing_position;
	}

}
