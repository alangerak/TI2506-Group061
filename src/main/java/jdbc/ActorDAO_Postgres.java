package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TI2506_Group061.MovieDatabaseConnector.DAOManager;

public class ActorDAO_Postgres implements ActorDAO {

	public Actor getActor(String lname, String fname) {
		Connection connection = DAOManager.getInstance().getDBConnection();
		String selectActorSQL = "SELECT * FROM actors WHERE actors.lname=? AND actors.fname=? LIMIT 1";

		Actor actor = new Actor();
		try {
			PreparedStatement pstmt = connection.prepareStatement(selectActorSQL);
			pstmt.setString(1, lname);
			pstmt.setString(2, fname);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				actor.setId(rs.getInt("idactors"));
				actor.setLname(rs.getString("lname"));
				actor.setFname(rs.getString("fname"));
				actor.setMname(rs.getString("mname"));
				actor.setGender(rs.getString("gender"));
				actor.setNumber(rs.getInt("number"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	public void printFilmography(String lname, String fname) {
		// TODO Auto-generated method stub

	}

}
