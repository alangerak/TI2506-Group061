package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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

			}

			String selectAka_titleSQL = "SELECT * FROM aka_titles WHERE aka_titles.idmovies=?";
			pstmt = connection.prepareStatement(selectAka_titleSQL);
			pstmt.setInt(1, movie.getId());
			rs = pstmt.executeQuery();

			movie.setAka_titles(new HashSet<Aka_title>());
			
			Map<Integer, Aka_title> aka_titlesById = new HashMap<Integer, Aka_title>();
			while (rs.next()) {
				Aka_title aka_title = aka_titlesById.get(movie.getId());
				if (aka_title == null) {
					aka_title = new Aka_title();
					aka_title.setId(rs.getInt("idaka_titles"));
					aka_title.setTitle(rs.getString("title"));
					aka_title.setYear(Year.of(rs.getInt("year")));
					aka_title.setLocation(rs.getString("location"));
					aka_titlesById.put(aka_title.getId(), aka_title);
				}
				movie.addAka_title(aka_title);
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
