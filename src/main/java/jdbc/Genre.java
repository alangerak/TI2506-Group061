package jdbc;

public class Genre {

	private int id;
	private String genre;
	
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
	
	//Debugging String maybe?
	public void printGenreObject(){
		System.out.format("%10d%60s", id, genre);
		System.out.print("\n");
	}

}
