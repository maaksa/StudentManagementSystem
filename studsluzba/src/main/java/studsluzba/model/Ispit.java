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
@Table(name = "ispit")
public class Ispit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspit;

	private LocalDate datumOdrzavanja;
	private String vremePocetka;
	private boolean unetiPoeni;
	
	@OneToOne
	@JoinColumn(name = "idPredmet") 
	private Predmet predmet;
	
	@OneToOne 
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;

	public Ispit() {
		super();
	}

	public Ispit(int idIspit, LocalDate datumOdrzavanja, Predmet predmet, Nastavnik nastavnik, String vremePocetka) {
		this.idIspit = idIspit;
		this.datumOdrzavanja = datumOdrzavanja;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.vremePocetka = vremePocetka;
	}

	public int getIdIspit() {
		return idIspit;
	}

	public void setIdIspit(int idIspit) {
		this.idIspit = idIspit;
	}

	public LocalDate getDatumOdrzavanja() {
		return datumOdrzavanja;
	}

	public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
		this.datumOdrzavanja = datumOdrzavanja;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public String getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(String vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public boolean isUnetiPoeni() {
		return unetiPoeni;
	}

	public void setUnetiPoeni(boolean unetiPoeni) {
		this.unetiPoeni = unetiPoeni;
	}

}
