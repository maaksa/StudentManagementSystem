package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "izlazakIspit")
public class IzlazakNaIspit 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIzlazak;
	
	
	private int brojOsvojenihPoena;
	private String napomena;
	private boolean ponistavanje;
	
	//proveriti
	private PrijavaIspita prijavljenIspit;
	private boolean izasaoNaIspit;
	private Ispit ispit;	
	
}
