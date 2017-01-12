package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * The Class ActorDAO_Postgres.
 */
public class ActorDAO_Postgres implements ActorDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL.
	 */
	public Actor getActor(String fname, String lname) {
		EntityManager manager = DAOManager.getInstance().getDBConnection();
		//Select and fill query
		Query query = manager.createQuery(
				"FROM Actor A WHERE A.fname = :firstname AND A.lname = :lastname");
		query.setParameter("firstname", fname);
		query.setParameter("lastname", lname);
		query.setMaxResults(1);

		List<?> actor = query.getResultList();
		
		//If there is no result, return 0
		if(actor.isEmpty()){
			return null;
		}else{
			return (Actor)actor.get(0);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL and the results are displayed on the
	 * console.
	 */
	public void printFilmography(String fname, String lname) {
		Actor actor = getActor(fname,lname);
		
		//Check if there are no results
		if(actor == null){
			System.out.println();
			System.out.println("The Actor: \"" + fname + " " + lname + "\" was not found.");
			System.out.println();			
		}else{
			
			//Header
			System.out.println();
			System.out.format("%15s%100s", "Year:", "Title: \n");
			
			//Print results (fname,lname,character)
			for(Acted_in acted_in : actor.getActed_in()){
				System.out.format("%15s%100s", acted_in.getMovie().getYear(), acted_in.getMovie().getTitle());
				System.out.print("\n");
			}
			
		}

	}

}
