package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "upisGodina")
public class UpisGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUpisGodina;
	
	@OneToOne
	@JoinColumn(name = "idSkolskaGodina")
	private SkolskaGodina skolskaGodina;
	
	@OneToOne
	@JoinColumn(name = "idStudent")
	private Student student;
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
