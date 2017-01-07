package vanilla;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

import TI2506_Group061.MovieDatabaseConnector.DAOManager;

public class MovieDAO_Postgres implements MovieDAO {

	public Movie getMovie(String title) {
		Connection connection = DAOManager.getInstance().getDBConnection();
		String selectMovieSQL = "SELECT * FROM movies WHERE movies.title=?";

		Movie movie = new Movie();
		try {
			PreparedStatement pstmt = connection.prepareStatement(selectMovieSQL);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				movie.setId(rs.getInt("idmovies"));
				movie.setTitle(rs.getString("title"));
				movie.setYear(Year.of(rs.getInt("year")));
				movie.setType(rs.getString("type"));
				movie.setLocation(rs.getString("location"));
				movie.setLanguage(rs.getString("language"));

				//movie.printMovieObject();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movie;
	}

	public void printCast(String title) {
		// TODO Auto-generated method stub

	}

}
