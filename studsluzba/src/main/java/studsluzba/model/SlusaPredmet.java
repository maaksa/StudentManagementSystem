package studsluzba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class SlusaPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlusaPredmet;
	
	@OneToOne
	@JoinColumn(name = "idStudent")
	private Student student;
	
	@OneToOne
	@JoinColumn(name = "idDrziPredmet")
	private DrziPredmet drziPredmet;

	public SlusaPredmet() {
		super();
	}

	public SlusaPredmet(Student student, DrziPredmet drziPredmet) {
		super();
		this.student = student;
		this.drziPredmet = drziPredmet;

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	
	

}
