package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UpisGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUpisGodina;
	
	
	private SkolskaGodina skolskaGodina;
	
	private Student student;
	private int godinaUpisa;
	private LocalDate datum;
	private String napomena;


	public UpisGodina() {
		super();
	}


	public int getIdUpisGodina() {
		return idUpisGodina;
	}


	public void setIdUpisGodina(int idUpisGodina) {
		this.idUpisGodina = idUpisGodina;
	}


	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}


	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}
	
	
}
