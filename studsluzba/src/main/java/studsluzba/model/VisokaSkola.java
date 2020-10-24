package studsluzba.model;

import javax.persistence.*;

@Entity
@Table(name = "visokaSkola")
public class VisokaSkola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisokaSkola;
	private String naziv;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idStudent")
	private Student student;

	public VisokaSkola() {
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getIdVisokaSkola() {
		return idVisokaSkola;
	}

	public void setIdVisokaSkola(int idVisokaSkola) {
		this.idVisokaSkola = idVisokaSkola;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
