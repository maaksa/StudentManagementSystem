package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prijavaIspit")
public class PrijavaIspita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrijava;
	private LocalDate datum;
	private Ispit ispit;
	private Student student;

	public PrijavaIspita() {
		super();
	}

	public PrijavaIspita(int idPrijava, LocalDate datum, Ispit ispit) {
		super();
		this.idPrijava = idPrijava;
		this.datum = datum;
		this.ispit = ispit;
	}

	public int getIdPrijava() {
		return idPrijava;
	}

	public void setIdPrijava(int idPrijava) {
		this.idPrijava = idPrijava;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
