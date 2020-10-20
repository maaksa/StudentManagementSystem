package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student")
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idstudent;

	private String ime;
	private String prezime;
	private String srednjeIme;
	private long jmbg;
	private LocalDate daumRodjenja;
	private String mestoRodjenja;
	private String drzavljanstvo;
	private String nacionalnost;
	private char pol;
	private String mesto;
	private String ulica;
	private int brojUlice;
	private long brojTelefona;
	private String Privemail;
	private String Studemail;
	private String brojLicneKarte;
	private String licnuKartuIzdao;
	private SrednjaSkola srednjaSkola;
	private VisokaSkola VisokaSkola;

	private boolean upisaoPrvuGodinu;
	private double uspehSrednjaSkola;
	private double uspehPrijemni;

	private boolean prelaz;
	
	@OneToMany
	private List<StudIndex> indexi;

	// bi-directional many-to-one association to StudProgram
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;

	public Student() {
	}

	public Student(String ime, String prezime, StudProgram studProgram) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.studProgram = studProgram;
	}

	public int getIdstudent() {
		return this.idstudent;
	}

	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public StudProgram getStudProgram() {
		return this.studProgram;
	}

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}

	@Override
	public String toString() {
		return "Student [idstudent=" + idstudent + ", ime=" + ime + ", prezime="
				+ prezime + ", studProgram=" + studProgram + "]";
	}

	public String getSrednjeIme() {
		return srednjeIme;
	}

	public void setSrednjeIme(String srednjeIme) {
		this.srednjeIme = srednjeIme;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public LocalDate getDaumRodjenja() {
		return daumRodjenja;
	}

	public void setDaumRodjenja(LocalDate daumRodjenja) {
		this.daumRodjenja = daumRodjenja;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}

	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public String getNacionalnost() {
		return nacionalnost;
	}

	public void setNacionalnost(String nacionalnost) {
		this.nacionalnost = nacionalnost;
	}

	public char getPol() {
		return pol;
	}

	public void setPol(char pol) {
		this.pol = pol;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public int getBrojUlice() {
		return brojUlice;
	}

	public void setBrojUlice(int brojUlice) {
		this.brojUlice = brojUlice;
	}

	public long getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(long brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getPrivemail() {
		return Privemail;
	}

	public void setPrivemail(String privemail) {
		Privemail = privemail;
	}

	public String getStudemail() {
		return Studemail;
	}

	public void setStudemail(String studemail) {
		Studemail = studemail;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getLicnuKartuIzdao() {
		return licnuKartuIzdao;
	}

	public void setLicnuKartuIzdao(String licnuKartuIzdao) {
		this.licnuKartuIzdao = licnuKartuIzdao;
	}

	public List<StudIndex> getIndexi() {
		return indexi;
	}

	public void setIndexi(List<StudIndex> indexi) {
		this.indexi = indexi;
	}

	public boolean isUpisaoPrvuGodinu() {
		return upisaoPrvuGodinu;
	}

	public void setUpisaoPrvuGodinu(boolean upisaoPrvuGodinu) {
		this.upisaoPrvuGodinu = upisaoPrvuGodinu;
	}

	public double getUspehSrednjaSKola() {
		return uspehSrednjaSkola;
	}

	public void setUspehSrednjaSKola(double uspehSrednjaSKola) {
		this.uspehSrednjaSkola = uspehSrednjaSKola;
	}

	public double getUspehPrijemni() {
		return uspehPrijemni;
	}

	public void setUspehPrijemni(double uspehPrijemni) {
		this.uspehPrijemni = uspehPrijemni;
	}

	public boolean isPrelaz() {
		return prelaz;
	}

	public void setPrelaz(boolean prelaz) {
		this.prelaz = prelaz;
	}
	public VisokaSkola getVisokaSkola() {
		return VisokaSkola;
	}
	public void setVisokaSkola(VisokaSkola visokaSkola) {
		VisokaSkola = visokaSkola;
	}
	public SrednjaSkola getSrednjaSkola() {
		return srednjaSkola;
	}
	public void setSrednjaSkola(SrednjaSkola srednjaSkola) {
		this.srednjaSkola = srednjaSkola;
	}
}