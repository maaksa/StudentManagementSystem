package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skolskaGodina")
public class SkolskaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskaGodina;
	
	
}
