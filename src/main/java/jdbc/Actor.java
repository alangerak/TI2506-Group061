package jdbc;

import java.util.Set;

/**
 * POJO that represents a single actor(row) from the table actor of the database.
 * It can also store the alternative names of the actor from the table aka_names.
 *
 */
public class Actor {

	/** The id. */
	private int id;
	
	/** The last name. */
	private String lname;
	
	/** The first name. */
	private String fname;
	
	/** The middle name. */
	private String mname;
	
	/** The gender. */
	private String gender;
	
	/** The number. */
	private int number;
	
	/** The aka names. */
	private Set<Aka_name> aka_names;

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
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(int number) {
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
	
	public void addAka_name(Aka_name aka_name){
		aka_names.add(aka_name);
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
	
	//Debugging String maybe?
	public void printActorObject(){
		System.out.format("%10d%20s%15s%30s%20s%15d", id, fname, lname, mname, gender,number);
		System.out.print("\n");
	}

}
