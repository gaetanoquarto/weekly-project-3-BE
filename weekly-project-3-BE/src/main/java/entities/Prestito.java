package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prestati")
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(name = "ricercaTessera", query = "SELECT p FROM Prestito p WHERE p.restituzioneeffettiva IS NULL AND p.utente_id = :utente_id")
@NamedQuery(name = "ricercaPrestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.restituzioneeffettiva IS NULL AND p.restituzioneprevista < CURRENT_DATE ")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int utente_id;
	private String prestato;
	private LocalDate inizioprestito;
	private LocalDate restituzioneprevista;
	private LocalDate restituzioneeffettiva;
	
	@Override
	public String toString() {
		return"Numero tessera: " + this.utente_id + " | Titolo: " + this.prestato + " | inizio prestito: " + this.inizioprestito + " | restituzione prevista: " + this.restituzioneprevista;
	}

}
