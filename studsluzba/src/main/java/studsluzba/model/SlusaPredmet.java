package studsluzba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SlusaPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlusaPredmet;
	private Student student;
	private Predmet predmet;
	private SkolskaGodina skolskaGodina;

	public SlusaPredmet() {
		super();
	}

	public SlusaPredmet(Student student, Predmet predmet, SkolskaGodina skolskaGodina) {
		super();
		this.student = student;
		this.predmet = predmet;
		this.skolskaGodina = skolskaGodina;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

}
