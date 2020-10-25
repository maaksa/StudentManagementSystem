package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "izlazakIspit")
public class IzlazakNaIspit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIzlazak;

	private int brojOsvojenihPoena;
	private String napomena;
	private boolean ponistavanje;

	// proveriti
	@OneToOne
	@JoinColumn(name = "idPrijava")
	private PrijavaIspita prijavljenIspit;

	private boolean izasaoNaIspit;
	
	@OneToOne
	@JoinColumn(name = "idIspit") 
	private Ispit ispit;

	public IzlazakNaIspit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdIzlazak() {
		return idIzlazak;
	}

	public void setIdIzlazak(int idIzlazak) {
		this.idIzlazak = idIzlazak;
	}

	public int getBrojOsvojenihPoena() {
		return brojOsvojenihPoena;
	}

	public void setBrojOsvojenihPoena(int brojOsvojenihPoena) {
		this.brojOsvojenihPoena = brojOsvojenihPoena;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public boolean isPonistavanje() {
		return ponistavanje;
	}

	public void setPonistavanje(boolean ponistavanje) {
		this.ponistavanje = ponistavanje;
	}

	public PrijavaIspita getPrijavljenIspit() {
		return prijavljenIspit;
	}

	public void setPrijavljenIspit(PrijavaIspita prijavljenIspit) {
		this.prijavljenIspit = prijavljenIspit;
	}

	public boolean isIzasaoNaIspit() {
		return izasaoNaIspit;
	}

	public void setIzasaoNaIspit(boolean izasaoNaIspit) {
		this.izasaoNaIspit = izasaoNaIspit;
	}

	public Ispit getIspit() {
		return ispit;
	}

	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}

}
