package studsluzba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "drziPredmet")
public class DrziPredmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDrziPredmet;
	private String sifra;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idPredmet")
	private Predmet predmet; 
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idNastavnik")
	private Nastavnik nastavnik;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idSkolskaGodina")
	private SkolskaGodina skolskaGod;
	
	@OneToMany(mappedBy = "drziPredmet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
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

	public void addSlusaPredmet(SlusaPredmet predmeti){
		if(slusaPredmet == null){
			slusaPredmet = new ArrayList<>();
		}
		slusaPredmet.add(predmeti);
		predmeti.setDrziPredmet(this);
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

	public List<SlusaPredmet> getSlusaPredmet() {
		return slusaPredmet;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public void setSlusaPredmet(List<SlusaPredmet> slusaPredmet) {
		this.slusaPredmet = slusaPredmet;

	}
}
