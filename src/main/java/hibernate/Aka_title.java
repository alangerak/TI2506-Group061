package hibernate;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aka_titles")
public class Aka_title {

	@Id
	@Column(name = "idaka_titles" , unique = true)
	private int id;
	
	@Column(name = "title")	
	private String title;

	@Column(name = "location")	
	private String location;

	@Column(name = "year")	
	private Year year;
	
	@ManyToOne
	@JoinColumn(name = "idmovies")
	private Movie movie;

	public Aka_title() {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

}
