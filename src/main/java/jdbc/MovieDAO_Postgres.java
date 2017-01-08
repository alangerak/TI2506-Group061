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
		String selectMovieSQL = "SELECT idmovies,title,year,location,language FROM movies WHERE movies.title=? AND type='3'";

		Movie movie = new Movie();
		try {
			PreparedStatement pstmt = connection.prepareStatement(selectMovieSQL);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();

			// Check for a result
			if (!rs.isBeforeFirst()) {
				return null;
			}

			//Create a movie object
			while (rs.next()) {
				movie.setTitle(rs.getString("title"));
				movie.setYear(Year.of(rs.getInt("year")));
				movie.setLocation(rs.getString("location"));
				movie.setLanguage(rs.getString("language"));
				
				movie.setAka_titles(new HashSet<Aka_title>());
			}

			String selectAka_titleSQL = "SELECT idaka_titles,title,year,location FROM aka_titles WHERE aka_titles.idmovies=?";
			
			pstmt = connection.prepareStatement(selectAka_titleSQL);
			pstmt.setInt(1, movie.getId());
			rs = pstmt.executeQuery();

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

			String selectGenreSQL = "SELECT * FROM genres JOIN movies_genres ON movies_genres.idgenres = genres.idgenres WHERE movies_genres.idmovies=?";
			pstmt = connection.prepareStatement(selectGenreSQL);
			pstmt.setInt(1, movie.getId());
			rs = pstmt.executeQuery();

			movie.setGenres(new HashSet<Genre>());

			Map<Integer, Genre> genresById = new HashMap<Integer, Genre>();
			while (rs.next()) {
				Genre genre = genresById.get(movie.getId());
				if (genre == null) {
					genre = new Genre();
					genre.setId(rs.getInt("idgenres"));
					genre.setGenre(rs.getString("genre"));
					genresById.put(genre.getId(), genre);
				}
				movie.addGengre(genre);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movie;
	}

	public void printCast(String title) {
		Connection connection = DAOManager.getInstance().getDBConnection();
		String selectCastSQL = "SELECT * FROM acted_in JOIN movies ON (acted_in.idmovies = movies.idmovies) JOIN actors ON (actors.idactors = acted_in.idactors) WHERE movies.title=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(selectCastSQL);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();

			// TEMP
			System.out.println();
			System.out.format("%40s%40s%40s", "First Name:", "Last Name: ", "Character Name: \n");
			while (rs.next()) {
				// TEMP
				System.out.format("%40s%40s%40s", rs.getString("fname"), rs.getString("lname"),
						rs.getString("character"));
				System.out.print("\n");
			}
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
