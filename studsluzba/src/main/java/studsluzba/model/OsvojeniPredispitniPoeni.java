package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "osvojeniPoeni")
public class OsvojeniPredispitniPoeni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOsvojeniPoeni;
	private int ukupanBrojPoena;

	@ManyToOne
	@JoinColumn(name = "idStudent")
	private Student student;

	@OneToMany
	@JoinColumn(name = "idPredIspitne")
	private List <PredispitneObaveze> predIspitneObaveze;

	public OsvojeniPredispitniPoeni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdOsvojeniPoeni() {
		return idOsvojeniPoeni;
	}

	public void setIdOsvojeniPoeni(int idOsvojeniPoeni) {
		this.idOsvojeniPoeni = idOsvojeniPoeni;
	}

	public int getUkupanBrojPoena() {
		return ukupanBrojPoena;
	}

	public void setUkupanBrojPoena(int ukupanBrojPoena) {
		this.ukupanBrojPoena = ukupanBrojPoena;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<PredispitneObaveze> getPredIspitneObaveze() {
		return predIspitneObaveze;
	}

	public void setPredIspitneObaveze(List<PredispitneObaveze> predIspitneObaveze) {
		this.predIspitneObaveze = predIspitneObaveze;
	}

}
