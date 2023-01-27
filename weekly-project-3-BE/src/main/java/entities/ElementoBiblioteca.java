package entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "archivio")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "archivio_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "ricercaAnno", query = "SELECT e FROM ElementoBiblioteca e WHERE e.annoPubblicazione = :annoPubblicazione")
@NamedQuery(name = "ricercaTitolo", query = "SELECT e FROM ElementoBiblioteca e WHERE e.titolo LIKE :titolo")
public abstract class ElementoBiblioteca {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "isbn_seq" )
	@SequenceGenerator( name = "isbn_seq", sequenceName = "isbn_seq" )
	private long codiceIsbn;
	
	private String titolo;
	private int annoPubblicazione;
	private int nPagine;
	
	@Override
	public String toString() {
		return"Codice ISBN: " + this.getCodiceIsbn() + " | Titolo: " + this.getTitolo() + " | Anno pubblicazione: " + this.getAnnoPubblicazione() + " | Pagine: " 
	+ this.getNPagine();
	}

}
