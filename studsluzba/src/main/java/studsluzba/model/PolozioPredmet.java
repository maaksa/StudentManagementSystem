package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "polozioPredmet")
public class PolozioPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPolozioPredmet;
	private int ocena;

	@OneToOne
	@JoinColumn(name = "idVisokaSkola")
	private VisokaSkola visokaSkola;

	@OneToOne
	@JoinColumn(name = "idStudent")
	private Student student;

	@OneToOne
	@JoinColumn(name = "idPredmet")
	private Predmet predmet;

	public PolozioPredmet() {
		super();
	}

	public int getIdPolozioPredmet() {
		return idPolozioPredmet;
	}

	public void setIdPolozioPredmet(int idPolozioPredmet) {
		this.idPolozioPredmet = idPolozioPredmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public VisokaSkola getVisokaSkola() {
		return visokaSkola;
	}

	public void setVisokaSkola(VisokaSkola visokaSkola) {
		this.visokaSkola = visokaSkola;
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

}
