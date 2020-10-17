package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "srednjaSkola")
public class SrednjaSkola {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSrednjaSkola;
	
	
	private String naziv;
	private String mesto;
	//private enum vrsta;
}
