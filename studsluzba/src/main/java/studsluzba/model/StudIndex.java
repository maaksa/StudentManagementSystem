package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studIndex")
public class StudIndex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStudIndex;

	@OneToOne
	private StudProgram program;
	private int broj;
	private int godina;
	private boolean aktivan;
	private LocalDate odKadJeAktivan;

	public StudIndex(int idStudIndex, int broj, int godina, StudProgram program, boolean aktivan, LocalDate odKadJeAktivan) {
		super();
		this.idStudIndex = idStudIndex;
		this.broj = broj;
		this.godina = godina;
		this.program = program;
		this.aktivan = aktivan;
		this.odKadJeAktivan = odKadJeAktivan;
	}

	public int getIdStudIndex() {
		return idStudIndex;
	}

	public void setIdStudIndex(int idStudIndex) {
		this.idStudIndex = idStudIndex;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public StudProgram getProgram() {
		return program;
	}

	public void setProgram(StudProgram program) {
		this.program = program;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public LocalDate getOdKadJeAktivan() {
		return odKadJeAktivan;
	}

	public void setOdKadJeAktivan(LocalDate odKadJeAktivan) {
		this.odKadJeAktivan = odKadJeAktivan;
	}

	@Override
	public String toString() {
		return "Studentski index = [id = " + idStudIndex + ", broj =  " + broj + ", godina = " + godina
				+ ", studijski program " + program.getSkraceniNaziv() + ", aktivan od = " + odKadJeAktivan;
	}

}
