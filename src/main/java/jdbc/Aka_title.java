package jdbc;

import java.time.Year;

public class Aka_title {

	private int id;
	private String title;
	private String location;
	private Year year;

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
	
	//Debugging String maybe?
	public void printAka_titleObject(){
		System.out.format("%10d%60s%15s%20s", id, title, year.toString(), location);
		System.out.print("\n");
	}

}
