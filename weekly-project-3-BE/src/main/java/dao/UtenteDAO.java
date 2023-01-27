package dao;


import entities.Utente;
import utils.JpaUtil;

public class UtenteDAO extends JpaUtil{
	
public void save(Utente u) {
		
		try {
			
			t.begin();
			em.persist(u);
			t.commit();
			
			System.out.println("Utente inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'utente");
		}
		
	}

public int getUtenteById(int id) {
	Utente e = em.find(Utente.class, id);
	
	if( e == null ) {
		System.out.println( "Il numero di tessera " + id + " non esiste!" );
	}
	
	return e.getNumerotessera();
}

}
