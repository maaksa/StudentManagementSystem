package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "polozioPredmet")
public class PolozioPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPolozioPredmet;
	private int ocena;
	private float ukupanBrojPoena;
	private boolean priznatSaDrugogFaksa;

	//@OneToOne
	//@JoinColumn(name = "idVisokaSkola")
//	private VisokaSkola visokaSkola;

	//student indeks da bude
	@ManyToOne
	@JoinColumn(name = "idStudIndex")
	private StudIndex studentIndex;

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

	public StudIndex getStudent() {
		return studentIndex;
	}
	public StudIndex getStudentIndex() {
		return studentIndex;
	}
	public void setStudentIndex(StudIndex studentIndex) {
		this.studentIndex = studentIndex;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
}
