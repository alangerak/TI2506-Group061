package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "actors")
public class Actor {

	@Id
	@Column(name = "idactors" , unique = true)
	private int id;
	
	@Column(name = "lname")
	private String lname;
	
	@Column(name = "fname")	
	private String fname;
	
	@Column(name = "mname")		
	private String mname;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "number")	
	private Integer number;

	@OneToMany(mappedBy = "actor")
	private Set<Aka_name> aka_names;
	
	@OneToMany(mappedBy = "actor", fetch=FetchType.LAZY)
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
	
	//Debugging String maybe?
	public void printActorObject(){
		System.out.format("%10d%20s%15s%30s%20s%15d", id, fname, lname, mname, gender,number);
		System.out.print("\n");
	}

}