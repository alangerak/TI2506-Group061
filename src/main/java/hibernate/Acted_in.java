package hibernate;

public class Acted_in {

	private int id;
	private Movie movie;
	private Actor actor;
	private String character;
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
