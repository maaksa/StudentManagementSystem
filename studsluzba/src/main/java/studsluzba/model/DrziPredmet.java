package studsluzba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DrziPredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDrziPredmet;
	private Predmet predmet;
	private Nastavnik nastavnik;
	private SkolskaGodina skolskaGod;

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
