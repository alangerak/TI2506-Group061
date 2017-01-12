package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

	@Id
	@Column(name = "idgenres" , unique = true)	
	private int id;
	
	@Column(name = "genre")	
	private String genre;
	
	@ManyToMany
	@JoinTable(name="movies_genres", joinColumns=@JoinColumn(name="idgenres",referencedColumnName="idgenres"),
		inverseJoinColumns=@JoinColumn(name="idmovies",referencedColumnName="idmovies")
			)
	private Set<Movie> movies;
	
	public Genre(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
