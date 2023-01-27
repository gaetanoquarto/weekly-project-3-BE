package dao;

import java.util.List;

import javax.persistence.Query;

import entities.ElementoBiblioteca;
import entities.Libro;
import utils.JpaUtil;


public class ElementoBibliotecaDAO extends JpaUtil{
	
public void save(ElementoBiblioteca el) {
		
		try {
			
			t.begin();
			em.persist(el);
			t.commit();
			
			System.out.println("Elemento inserito correttamente!");
		}
		catch(Exception e) {
			System.out.println("Errore nell'inserimento dell'Elemento");
		}
		
	}

public void deleteByISBN(long codiceIsbn) {
	ElementoBiblioteca e = em.find(ElementoBiblioteca.class, codiceIsbn);
	
	if( e == null ) {
		System.out.println( "L'elemento con il codice ISBN " + codiceIsbn + " non è stato trovato!" );
		return;
	}
	
	t.begin();
	em.remove(e);
	t.commit();
	
	System.out.println( "L'elemento con il codice ISBN " + codiceIsbn + " è stato eliminato!" );
}

public void ricercaByISBN(long codiceIsbn) {
	
	ElementoBiblioteca l = em.find(ElementoBiblioteca.class, codiceIsbn);
	
	if( l == null ) {
		System.out.println( "Il Libro con il codice ISBN " + codiceIsbn + " non è stato trovato!" );
		return;
	}
	System.out.println( "Dati Elemento #" + codiceIsbn );
	System.out.printf(  
		"Titolo: %s | Anno pubblicazione: %d | Pagine: %d%n",
		l.getTitolo(), l.getAnnoPubblicazione(), l.getNPagine());
}

public void ricercaByAnno(int anno) {
	
	try {
		Query query = em.createNamedQuery("ricercaAnno");
		query.setParameter("annoPubblicazione", anno);
		List<ElementoBiblioteca> elemento = query.getResultList();
		System.out.println("Carico elementi con l'anno: " + anno);
		for(ElementoBiblioteca e : elemento) {
			System.out.println(e);
		}
	} catch(Exception e) {
		System.out.println("Elemento non trovato!");
	}
	
}
public void ricercaByAutore(String autore) {
	
	try {
		 Query query = em.createNamedQuery("ricercaAutore");
			query.setParameter("autore", autore);
			List<Libro> libri = query.getResultList();
			System.out.println("Carico elementi con l'autore: " + autore);
			for(ElementoBiblioteca e : libri) {
				System.out.println(e);
			}
		
	} catch(Exception e) {
		System.out.println("Elemento non trovato!");
	}
	
}

		public void ricercaParzialeTitolo(String titolo) {
			
			try {
				Query query = em.createNamedQuery("ricercaTitolo");
				query.setParameter("titolo", "%"+titolo+"%");
				List<ElementoBiblioteca> elemento = query.getResultList();
				System.out.println("Carico elementi con il titolo: " + titolo);
				for(ElementoBiblioteca e : elemento) {
					System.out.println(e);
				}
			} catch(Exception e) {
				System.out.println("Elemento non trovato!");
			}
			
			

}






}
