package jdbc;

public class Aka_name {

	private int id;
	private String name;

	public Aka_name() {
	}

	public int getId() {
		return id;
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
