package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
				
				actor.setActed_in(null);
			}
			
			String selectAka_nameSQL = "SELECT * FROM aka_names WHERE aka_names.idactors=?";
			pstmt = connection.prepareStatement(selectAka_nameSQL);
			pstmt.setInt(1, actor.getId());
			rs = pstmt.executeQuery();
			
			actor.setAka_names(new HashSet<Aka_name>());
			
			Map<Integer, Aka_name> aka_namesById = new HashMap<Integer, Aka_name>();
			while (rs.next()) {
				Aka_name aka_name = aka_namesById.get(actor.getId());
				if (aka_name == null) {
					aka_name = new Aka_name();
					aka_name.setId(rs.getInt("idaka_names"));	
					aka_name.setName(rs.getString("name"));
					aka_namesById.put(aka_name.getId(), aka_name);
				}
				actor.addAka_name(aka_name);
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
