package studsluzba.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "predispitneObaveze")
public class PredispitneObaveze {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredIspitne;

	private String vrstaObabeza;
	private int poeni;	
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idSkolskaGodina")
	private SkolskaGodina skolskaGodina;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idPredmet")
	private Predmet predmet;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idOsvojeniPoeni")
	private OsvojeniPredispitniPoeni osvojeniPredispitniPoeni;


	public PredispitneObaveze() {
		super();
	}

	public PredispitneObaveze( String vrstaObabeza, int maxBrp) {
		this.vrstaObabeza = vrstaObabeza;
		this.poeni = maxBrp;
	}



	public int getMaxBrp() {
		return poeni;
	}

	public void setMaxBrp(int maxBrp) {
		this.poeni = maxBrp;
	}

	public String getVrstaObabeza() {
		return vrstaObabeza;
	}

	public void setVrstaObabeza(String vrstaObabeza) {
		this.vrstaObabeza = vrstaObabeza;
	}

	public int getPoeni() {
		return poeni;
	}

	public void setPoeni(int poeni) {
		this.poeni = poeni;
	}

	public SkolskaGodina getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public OsvojeniPredispitniPoeni getOsvojeniPredispitniPoeni() {
		return osvojeniPredispitniPoeni;
	}

	public void setOsvojeniPredispitniPoeni(OsvojeniPredispitniPoeni osvojeniPredispitniPoeni) {
		this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
	}

	public void setIdPredIspitne(int idPredIspitne) {
		this.idPredIspitne = idPredIspitne;
	}
}
