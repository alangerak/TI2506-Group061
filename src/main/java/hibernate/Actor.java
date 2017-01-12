package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Actor.
 */
@Entity
@Table(name = "actors")
public class Actor {

	/** The id. */
	@Id
	@Column(name = "idactors" , unique = true)
	private int id;
	
	/** The lname. */
	@Column(name = "lname")
	private String lname;
	
	/** The fname. */
	@Column(name = "fname")	
	private String fname;
	
	/** The mname. */
	@Column(name = "mname")		
	private String mname;
	
	/** The gender. */
	@Column(name = "gender")
	private String gender;
	
	/** The number. */
	@Column(name = "number")	
	private Integer number;

	/** The aka names. 
	 * 
	 * Joins on its primary key with table aka_names
	 * */
	@OneToMany(mappedBy = "actor")
	private Set<Aka_name> aka_names;
	
	/** The acted in. 
	 * 
	 * Joins on its primary key with table acted_in
	 * */
	@OneToMany(mappedBy = "actor", fetch=FetchType.LAZY)
	private Set<Acted_in> acted_in;

	public Actor() {
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
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the lname.
	 *
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * Sets the lname.
	 *
	 * @param lname
	 *            the new lname
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * Gets the fname.
	 *
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * Sets the fname.
	 *
	 * @param fname
	 *            the new fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * Gets the mname.
	 *
	 * @return the mname
	 */
	public String getMname() {
		return mname;
	}

	/**
	 * Sets the mname.
	 *
	 * @param mname
	 *            the new mname
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Gets the aka names.
	 *
	 * @return the aka names
	 */
	public Set<Aka_name> getAka_names() {
		return aka_names;
	}

	/**
	 * Sets the aka names.
	 *
	 * @param aka_names
	 *            the new aka names
	 */
	public void setAka_names(Set<Aka_name> aka_names) {
		this.aka_names = aka_names;
	}

	/**
	 * Gets the acted in.
	 *
	 * @return the acted in
	 */
	public Set<Acted_in> getActed_in() {
		return acted_in;
	}

	/**
	 * Sets the acted in.
	 *
	 * @param acted_in
	 *            the new acted in
	 */
	public void setActed_in(Set<Acted_in> acted_in) {
		this.acted_in = acted_in;
	}

}
