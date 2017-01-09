package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ActorDAO_Postgres implements ActorDAO {

	public Actor getActor(String fname, String lname) {
		EntityManager manager = DAOManager.getInstance().getDBConnection();
		Query query = manager.createQuery(
				"FROM Actor A WHERE A.fname = :firstname AND A.lname = :lastname");
		query.setParameter("firstname", fname);
		query.setParameter("lastname", lname);
		query.setMaxResults(1);

		List<?> actor = query.getResultList();
		
		if(actor.isEmpty()){
			return null;
		}else{
			return (Actor)actor.get(0);
		}
	}

	public void printFilmography(String fname, String lname) {
		// TODO Auto-generated method stub

	}

}
