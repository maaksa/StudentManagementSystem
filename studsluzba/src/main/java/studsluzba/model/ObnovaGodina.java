package studsluzba.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ObnovaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObnovaGodina;
	
	/*
	private Student student;
	private SkolskaGodina skolskaGodina;
	private List<Predmet> predmetPrenos;
	private LocalDate datum;
	private String napomena;
	*/
	
	public ObnovaGodina() {
		super();
	}

	
}
