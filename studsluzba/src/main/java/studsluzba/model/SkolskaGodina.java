package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skolskaGodina")
public class SkolskaGodina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSkolskaGodina;
	private int datum;
	private boolean aktivna;

	
	
	@OneToMany
	@JoinColumn(name = "idIspitniRok") 
	private List<IspitniRok> ispitniRokovi;

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
