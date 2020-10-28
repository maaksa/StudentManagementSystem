package studsluzba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "osvojeniPoeni")
public class OsvojeniPredispitniPoeni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOsvojeniPoeni;
	private int ukupanBrojPoena;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idStudIndex")
	private StudIndex studentIndeks;

	@OneToMany(mappedBy = "osvojeniPredispitniPoeni", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List <PredispitneObaveze> predIspitneObaveze;

	public OsvojeniPredispitniPoeni() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addPredIspitne(PredispitneObaveze predObaveze){
		if(predIspitneObaveze == null){
			predIspitneObaveze = new ArrayList<>();
		}
		predIspitneObaveze.add(predObaveze);
		predObaveze.setOsvojeniPredispitniPoeni(this);
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

	public StudIndex getStudentIndeks() {
		return studentIndeks;
	}

	public void setStudentIndeks(StudIndex studentIndeks) {
		this.studentIndeks = studentIndeks;
	}

	public List<PredispitneObaveze> getPredIspitneObaveze() {
		return predIspitneObaveze;
	}

	public void setPredIspitneObaveze(List<PredispitneObaveze> predIspitneObaveze) {
		this.predIspitneObaveze = predIspitneObaveze;
	}



}
