package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "srednjaSkola")
public class SrednjaSkola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSrednjaSkola;

	private String naziv;
	private String mesto;
	private String vrsta;

	public SrednjaSkola() {
		super();
	}

	public SrednjaSkola(int idSrednjaSkola, String naziv, String mesto, String vrsta) {
		this.idSrednjaSkola = idSrednjaSkola;
		this.naziv = naziv;
		this.mesto = mesto;
		this.vrsta = vrsta;
	}

	public int getIdSrednjaSkola() {
		return idSrednjaSkola;
	}

	public void setIdSrednjaSkola(int idSrednjaSkola) {
		this.idSrednjaSkola = idSrednjaSkola;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

}
