package entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@Getter
@Setter
public class Utente{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numerotessera;
	private String nome;
	private String cognome;
	private LocalDate datanascita;

	
	
}
