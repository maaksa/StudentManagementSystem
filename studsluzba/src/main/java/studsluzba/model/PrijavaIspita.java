package studsluzba.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "prijavaIspit")
public class PrijavaIspita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrijava;
	private LocalDate datum;
	
	@ManyToOne
	@JoinColumn(name = "idIspit")
	private Ispit ispit;
	
	//@OneToMany
	//@JoinColumn(name = "idStudent")
	//private List<StudIndex> student;

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


}
