package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drziPredmet")
public class DrziPredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDrziPredmet;
	
	@ManyToOne
	@JoinColumn(name = "idPredmet")
	private Predmet predmet; 
	
	@ManyToOne
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	@ManyToOne
	@JoinColumn(name = "idSkolskaGodina")
	private SkolskaGodina skolskaGod;
	
	@OneToMany(mappedBy = "drziPredmet")
	private List<SlusaPredmet> slusaPredmet;

	public DrziPredmet() {
		super();
	}

	public DrziPredmet(Predmet predmet, Nastavnik nastavnik, SkolskaGodina skolskaGod) {
		super();
		this.predmet = predmet;
		this.nastavnik = nastavnik;
		this.skolskaGod = skolskaGod;
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

	public SkolskaGodina getSkolskaGod() {
		return skolskaGod;
	}

	public void setSkolskaGod(SkolskaGodina skolskaGod) {
		this.skolskaGod = skolskaGod;
	}

}
