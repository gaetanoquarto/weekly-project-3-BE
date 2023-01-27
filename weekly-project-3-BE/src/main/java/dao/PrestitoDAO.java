package dao;

import java.util.List;

import javax.persistence.Query;

import entities.ElementoBiblioteca;
import entities.Libro;
import entities.Prestito;
import utils.JpaUtil;

public class PrestitoDAO extends JpaUtil {
	
public void save(Prestito p) {
		
		try {
			
			t.begin();
			em.persist(p);
			t.commit();
			
			System.out.println("Prestito inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento del Prestito");
		}
		
	}

public void ricercaByTessera(int numeroTessera) {
	
	 Query query = em.createNamedQuery("ricercaTessera");
		query.setParameter("utente_id", numeroTessera);
		List<Prestito> prestiti = query.getResultList();
		System.out.println("Carico elementi non consegnati con il numero tessera: " + numeroTessera);
		for(Prestito e : prestiti) {
			System.out.println(e);
		}
}
public void ricercaScaduti() {
	
	Query query = em.createNamedQuery("ricercaPrestitiScaduti");
	List<Prestito> prestiti = query.getResultList();
	System.out.println("Carico elementi non consegnati in tempo: ");
	for(Prestito e : prestiti) {
		System.out.println(e);
	}
}



}
