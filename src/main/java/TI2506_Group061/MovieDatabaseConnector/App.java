package TI2506_Group061.MovieDatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import vanilla.Movie;

public class App {

	public static void main(String[] argv) {

		DAOManager manager = DAOManager.getInstance();
		Connection connection = manager.getDBConnection();;

		if (connection != null) {
			try {
				viewTable(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void viewTable(Connection con) throws SQLException {

		String selectTableSQL = "SELECT * FROM movies LIMIT 100";
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(selectTableSQL);
		System.out.println();
		System.out.format("%10s%60s%15s%15s%20s%20s%20s", "ID", "Title", "Year", " Number", "Type","Location","Language \n");
		
		while (rs.next()) {
			Movie movie = new Movie();
			movie.setId(rs.getInt("idmovies"));
			movie.setTitle(rs.getString("title"));
			movie.setYear(Year.of(rs.getInt("year")));
			movie.setType(rs.getString("type"));
			movie.setLocation(rs.getString("location"));
			movie.setLanguage(rs.getString("language"));

			movie.printMovieObject();

		}

	}
}