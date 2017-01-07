package vanilla;

import java.util.Set;

public class Actor {

	private int id;
	private String lname;
	private String fname;
	private String mname;
	private String gender;
	private int number;
	private Set<Aka_name> aka_names;
	private Set<Acted_in> acted_in;

	public Actor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Set<Aka_name> getAka_names() {
		return aka_names;
	}

	public void setAka_names(Set<Aka_name> aka_names) {
		this.aka_names = aka_names;
	}

	public Set<Acted_in> getActed_in() {
		return acted_in;
	}

	public void setActed_in(Set<Acted_in> acted_in) {
		this.acted_in = acted_in;
	}

}
