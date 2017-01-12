
package hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * The Class MovieDAO_Postgres.
 */
public class MovieDAO_Postgres implements MovieDAO {

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL.
	 */
	public Movie getMovie(String title) {
		EntityManager manager = DAOManager.getInstance().getDBConnection();
		Query query = manager.createQuery(
				"FROM Movie M WHERE M.title = :title AND M.type = 3");
		query.setParameter("title", title);
		query.setMaxResults(1);

		List<?> movie = query.getResultList();
		
		if(movie.isEmpty()){
			return null;
		}else{
			return (Movie)movie.get(0);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Implementation is using PostgreSQL and the results are displayed on the
	 * console.
	 */
	public void printCast(String title) {
		Movie movie = getMovie(title);
		
		//Check for results
		if(movie == null){
			System.out.println();
			System.out.println("The Movie: \"" + title + "\" was not found.");
			System.out.println();			
		}else{
			
			// Print Header
			System.out.format("\n %40s%40s%40s", "First Name:", "Last Name: ", "Character Name: \n");

			//Print results
			for(Acted_in acted_in : movie.getActed_in()){
				System.out.format("%40s%40s%40s", acted_in.getActor().getFname(), acted_in.getActor().getLname(),
						acted_in.getCharacter());
				System.out.print("\n");				
			}
			
		}
	}

}
