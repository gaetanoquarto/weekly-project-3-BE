package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "libri")
@DiscriminatorValue("Libro")
@Getter
@Setter
@NamedQuery(name = "ricercaAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
public class Libro extends ElementoBiblioteca{

	private String autore;
	private String genere;
	
	@Override
	public String toString() {
		return"Codice ISBN: " + this.getCodiceIsbn() + " | Titolo: " + this.getTitolo() + " | Anno pubblicazione: " + this.getAnnoPubblicazione() + " | Pagine: " 
	+ this.getNPagine() + " | Autore: " + this.autore + " | Genere: " + this.genere;
	}
}



