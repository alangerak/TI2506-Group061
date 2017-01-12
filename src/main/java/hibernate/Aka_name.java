package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aka_names")
public class Aka_name {

	@Id
	@Column(name = "idaka_names" , unique = true)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "idactors")
	private Actor actor;

	public Aka_name() {
	}

	public int getId() {
		return id;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//Debugging String maybe?
	public void printAka_nameObject(){
		System.out.format("%10d%60s", id, name);
		System.out.print("\n");
	}

}
