package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the studProgram database table.
 * 
 */
@Entity
@Table(name = "studProgram")
@NamedQuery(name = "StudProgram.findAll", query = "SELECT s FROM StudProgram s")
public class StudProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idstudProgram;

	private String naziv;
	private String skraceniNaziv;
	private LocalDate godinaAkreditacije;
	private int trajanje;
	private String nazivZvanja;
	private VrstaStudija vrstaStudija; 		//ovo vadimo is sifarnika

	// bi-directional many-to-one association to Student
	@OneToMany(mappedBy = "studProgram")
	private List<Student> students;

	@OneToMany(mappedBy = "studProgram")
	private List<Predmet> predmeti;

	public StudProgram() {
	}

	public int getIdstudProgram() {
		return this.idstudProgram;
	}

	public void setIdstudProgram(int idstudProgram) {
		this.idstudProgram = idstudProgram;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSkraceniNaziv() {
		return this.skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}

	public LocalDate getGodinaAkreditacije() {
		return godinaAkreditacije;
	}

	public void setGodinaAkreditacije(LocalDate godinaAkreditacije) {
		this.godinaAkreditacije = godinaAkreditacije;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getNazivZvanja() {
		return nazivZvanja;
	}

	public void setNazivZvanja(String nazivZvanja) {
		this.nazivZvanja = nazivZvanja;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setStudProgram(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setStudProgram(null);

		return student;
	}

	@Override
	public String toString() {
		return skraceniNaziv + "-" + naziv;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmets) {
		this.predmeti = predmets;
	}

	public VrstaStudija getVrstaStudija() {
		return vrstaStudija;
	}

	public void setVrstaStudija(VrstaStudija vrstaStudija) {
		this.vrstaStudija = vrstaStudija;
	}

}