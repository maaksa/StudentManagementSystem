package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skolskaGodina")
public class SkolskaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskaGodina;

	// Da li trebaju liste ili samo ID
	// private List<Predmet> predemti;
	// private List<Nastavnik> nastavnici;
	// private List<Student> studenti;

	public SkolskaGodina() {
		super();
	}

	public int getIdSkolskaGodina() {
		return idSkolskaGodina;
	}

	public void setIdSkolskaGodina(int idSkolskaGodina) {
		this.idSkolskaGodina = idSkolskaGodina;
	}
	/*
	 * public List<Predmet> getPredemti() { return predemti; }
	 * 
	 * public void setPredemti(List<Predmet> predemti) { this.predemti = predemti; }
	 * 
	 * public List<Nastavnik> getNastavnici() { return nastavnici; }
	 * 
	 * public void setNastavnici(List<Nastavnik> nastavnici) { this.nastavnici =
	 * nastavnici; }
	 */
}
