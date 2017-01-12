package hibernate;

import java.time.Year;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@Column(name = "idmovies" , unique = true)
	private int id;
	
	@Column(name = "title")	
	private String title;
	
	@Column(name = "year")	
	private Year year;
	
	@Column(name = "number")	
	private int number;
	
	@Column(name = "type")	
	private String type;
	
	@Column(name = "location")	
	private String location;
	
	@Column(name = "language")	
	private String language;
	
	@ManyToMany(mappedBy="movies")
	private Set<Genre> genres;
	
	@OneToMany(mappedBy = "movie")	
	private Set<Aka_title> aka_titles;
	
	@OneToMany(mappedBy = "movie", fetch=FetchType.LAZY)	
	private Set<Acted_in> acted_in;
	

	public Movie() {
	}	

	public Set<Acted_in> getActed_in() {
		return acted_in;
	}

	public void setActed_in(Set<Acted_in> acted_in) {
		this.acted_in = acted_in;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void printMovieObject(){
		System.out.format("%10d%60s%15s%15s%20s%20s%20s", id, title, year.toString(), number, type,location,language);
		System.out.print("\n");
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Aka_title> getAka_titles() {
		return aka_titles;
	}

	public void setAka_titles(Set<Aka_title> aka_titles) {
		this.aka_titles = aka_titles;
	}

}
