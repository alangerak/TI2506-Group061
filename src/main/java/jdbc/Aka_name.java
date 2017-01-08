package jdbc;

/**
 * The Class Aka_name.
 */
public class Aka_name {

	/** The id. */
	private int id;
	
	/** The name. */
	private String name;

	public Aka_name() {
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//Debugging String maybe?
	public void printAka_nameObject(){
		System.out.format("%10d%60s", id, name);
		System.out.print("\n");
	}

}
