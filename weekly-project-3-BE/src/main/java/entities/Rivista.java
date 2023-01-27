package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "riviste")
@DiscriminatorValue("Rivista")
@Getter
@Setter
public class Rivista extends ElementoBiblioteca{
	
	@Enumerated(EnumType.STRING)
	Periodicita periodicita;

}
