package studsluzba.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "obnovaGodine")
public class ObnovaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObnovaGodina;

	private LocalDate datum;
	private String napomena;
	
	//indeks
	@ManyToOne
	@JoinColumn(name = "idStudIndex")
	private StudIndex studentIndeks;
	
	@OneToOne
	@JoinColumn(name = "idSkolskaGodina")
	private SkolskaGodina skolskaGodina;
	
	/*@OneToMany
	@JoinColumn(name = "idPredmet")
	private List<Predmet> predmetPrenos;*/
	

	public ObnovaGodina() {
		super();
	}

	public int getIdObnovaGodina() {
		return idObnovaGodina;
	}

	public void setIdObnovaGodina(int idObnovaGodina) {
		this.idObnovaGodina = idObnovaGodina;
	}

	public StudIndex getStudentIndex() {
		return studentIndeks;
	}

	public void setStudentIndex(StudIndex studentIndeks) {
		this.studentIndeks = studentIndeks;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	/*public List<Predmet> getPredmetPrenos() {
		return predmetPrenos;
	}

	public void setPredmetPrenos(List<Predmet> predmetPrenos) {
		this.predmetPrenos = predmetPrenos;
	}*/

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

}
