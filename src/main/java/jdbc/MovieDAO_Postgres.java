package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.HashSet;

import TI2506_Group061.MovieDatabaseConnector.DAOManager;

/**
 * Implementation of MovieDAO using PostgreSQL.
 *
 */
public class MovieDAO_Postgres implements MovieDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL.
	 */
	public Movie getMovie(String title) {

		Movie movie = null;

		try {
			Connection connection = DAOManager.getInstance().getDBConnection();

			// Select the movie
			String selectMovieSQL = "SELECT idmovies,title,year,location,language FROM movies WHERE movies.title=? AND type='3'";
			PreparedStatement pstmt = connection.prepareStatement(selectMovieSQL);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();

			// First, check if a movie is found
			if (!rs.isBeforeFirst()) {
				return null;
			}

			// Create Movie object, then add the aka titles and genre to it
			movie = createMovie(rs);
			addAka_TitleToMovie(movie);
			addGenreToMovie(movie);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movie;
	}

	/**
	 * Helper method to create a movie from a query
	 * 
	 * @param rs
	 *            ResultSet from the movie query
	 * @return movie object
	 * @throws SQLException
	 */
	private Movie createMovie(ResultSet rs) throws SQLException {
		Movie movie = new Movie();

		// Create a movie object
		while (rs.next()) {
			movie.setId(rs.getInt("idmovies"));
			movie.setTitle(rs.getString("title"));
			movie.setYear(Year.of(rs.getInt("year")));
			movie.setLocation(rs.getString("location"));
			movie.setLanguage(rs.getString("language"));

			movie.setAka_titles(new HashSet<Aka_title>());
			movie.setGenres(new HashSet<Genre>());
		}

		return movie;
	}

	/**
	 * Helper method to find and add all the aka titles of a movie
	 * 
	 * @param movie
	 *            the target movie
	 * @throws SQLException
	 */
	private void addAka_TitleToMovie(Movie movie) throws SQLException {
		Connection connection = DAOManager.getInstance().getDBConnection();

		// Select all aka_titles of the movie
		String selectAka_titleSQL = "SELECT idaka_titles,title,year,location FROM aka_titles WHERE aka_titles.idmovies=?";

		PreparedStatement pstmt = connection.prepareStatement(selectAka_titleSQL);
		pstmt.setInt(1, movie.getId());
		ResultSet rs = pstmt.executeQuery();

		// Create aka_title object
		while (rs.next()) {
			Aka_title aka_title = new Aka_title();
			aka_title.setId(rs.getInt("idaka_titles"));
			aka_title.setTitle(rs.getString("title"));
			aka_title.setYear(Year.of(rs.getInt("year")));
			aka_title.setLocation(rs.getString("location"));

			movie.addAka_title(aka_title);
		}
	}

	/**
	 * Helper method to find and add the genres of a movie
	 * 
	 * @param movie
	 *            the target movie
	 * @throws SQLException
	 */
	private void addGenreToMovie(Movie movie) throws SQLException {
		Connection connection = DAOManager.getInstance().getDBConnection();

		// Select all genres of the movie
		String selectGenreSQL = "SELECT * FROM genres JOIN movies_genres ON movies_genres.idgenres = genres.idgenres WHERE movies_genres.idmovies=?";

		PreparedStatement pstmt = connection.prepareStatement(selectGenreSQL);
		pstmt.setInt(1, movie.getId());
		ResultSet rs = pstmt.executeQuery();

		// Create genre object
		while (rs.next()) {
			Genre genre = new Genre();
			genre.setId(rs.getInt("idgenres"));
			genre.setGenre(rs.getString("genre"));

			movie.addGengre(genre);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL and the results are displayed on the
	 * console.
	 */
	public void printCast(String title) {
		Connection connection = DAOManager.getInstance().getDBConnection();
		// Select all actors that played in the movie
		String selectCastSQL = "SELECT fname,lname,character FROM acted_in JOIN movies ON (acted_in.idmovies = movies.idmovies) JOIN actors ON (actors.idactors = acted_in.idactors) WHERE movies.title=?";

		try {
			PreparedStatement pstmt = connection.prepareStatement(selectCastSQL);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();

			// First, check if a movie is found
			if (!rs.isBeforeFirst()) {
				System.out.println();
				System.out.println("The Movie: \"" + title + "\" was not found.");
				System.out.println();
			} else {

				// Print Header
				System.out.format("\n %40s%40s%40s", "First Name:", "Last Name: ", "Character Name: \n");

				// Print the cast with fname,lname,character
				while (rs.next()) {
					System.out.format("%40s%40s%40s", rs.getString("fname"), rs.getString("lname"),
							rs.getString("character"));
					System.out.print("\n");
				}
				System.out.println();

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
