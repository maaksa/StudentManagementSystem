package studsluzba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ObnovaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObnovaGodina;
	private SkolskaGodina skolskaGodina;
	public ObnovaGodina() {
		super();
	}

	
}
