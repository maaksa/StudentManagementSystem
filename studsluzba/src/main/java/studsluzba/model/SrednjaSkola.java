package studsluzba.model;

import javax.persistence.*;

@Entity
@Table(name = "srednjaSkola")
public class SrednjaSkola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSrednjaSkola;

	private String naziv;
	private String mesto;
	private String vrsta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStudent")
	private Student student;

	public SrednjaSkola(){

	}

	public SrednjaSkola(String naziv, String mesto, String vrsta) {
		this.naziv = naziv;
		this.mesto = mesto;
		this.vrsta = vrsta;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public int getIdSrednjaSkola() {
		return idSrednjaSkola;
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
