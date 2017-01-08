package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import TI2506_Group061.MovieDatabaseConnector.DAOManager;

public class ActorDAO_Postgres implements ActorDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL.
	 */
	public Actor getActor(String fname, String lname) {
		Connection connection = DAOManager.getInstance().getDBConnection();
		String selectActorSQL = "SELECT idactors,fname,lname,mname,gender,number FROM actors WHERE actors.lname=? AND actors.fname=? LIMIT 1";

		Actor actor = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement(selectActorSQL);
			pstmt.setString(1, lname);
			pstmt.setString(2, fname);
			ResultSet rs = pstmt.executeQuery();

			// First, check if an actor is found
			if (!rs.isBeforeFirst()) {
				return null;
			}

			// Create actor object and add the aka names to it.
			actor = createActor(rs);
			addAka_NamesToActor(actor);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	/**
	 * Helper method to create an actor from a query
	 * 
	 * @param rs
	 *            ResultSet from the actor query
	 * @return actor object
	 * @throws SQLException
	 */
	private Actor createActor(ResultSet rs) throws SQLException {

		Actor actor = new Actor();

		while (rs.next()) {
			actor.setId(rs.getInt("idactors"));
			actor.setLname(rs.getString("lname"));
			actor.setFname(rs.getString("fname"));
			actor.setMname(rs.getString("mname"));
			actor.setGender(rs.getString("gender"));
			actor.setNumber(rs.getInt("number"));
		}

		return actor;
	}

	/**
	 * Helper method to find and add the aka names of an actor
	 * 
	 * @param actor
	 *            the target actor
	 * @throws SQLException
	 */
	private void addAka_NamesToActor(Actor actor) throws SQLException {
		Connection connection = DAOManager.getInstance().getDBConnection();

		String selectAka_nameSQL = "SELECT idaka_names,name FROM aka_names WHERE aka_names.idactors=?";
		PreparedStatement pstmt = connection.prepareStatement(selectAka_nameSQL);
		pstmt.setInt(1, actor.getId());
		ResultSet rs = pstmt.executeQuery();

		actor.setAka_names(new HashSet<Aka_name>());

		while (rs.next()) {
			Aka_name aka_name = new Aka_name();
			aka_name.setId(rs.getInt("idaka_names"));
			aka_name.setName(rs.getString("name"));
			actor.addAka_name(aka_name);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL and the results are displayed on the
	 * console.
	 */
	public void printFilmography(String fname, String lname) {

		// Temp
		Actor actor = getActor(fname, lname);

		if (actor == null) {
			System.out.println();
			System.out.println("The Actor: \"" + fname + " " + lname + "\" was not found.");
			System.out.println();
		} else {
			Connection connection = DAOManager.getInstance().getDBConnection();
			String selectFilmographySQL = "SELECT * FROM acted_in JOIN movies ON (acted_in.idmovies = movies.idmovies) JOIN actors ON (actors.idactors = acted_in.idactors) WHERE actors.idactors=?";

			try {
				PreparedStatement pstmt = connection.prepareStatement(selectFilmographySQL);
				pstmt.setInt(1, actor.getId());
				ResultSet rs = pstmt.executeQuery();

				// TEMP
				System.out.println();
				System.out.format("%15s%100s", "Year:", "Title: \n");
				while (rs.next()) {
					// TEMP
					System.out.format("%15s%100s", rs.getString("year"), rs.getString("title"));
					System.out.print("\n");
				}
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
