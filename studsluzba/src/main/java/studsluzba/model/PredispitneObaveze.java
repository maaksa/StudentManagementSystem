package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enums.VrstaObaveze;

@Entity
@Table(name = "predispitneObaveze")
public class PredispitneObaveze {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int predispitneid;

	private VrstaObaveze vrsta;
	private int maxBrp;
	private Predmet predmet;

	public PredispitneObaveze(int predispitneid, VrstaObaveze vrsta, int maxBrp, Predmet predmet) {
		this.predispitneid = predispitneid;
		this.vrsta = vrsta;
		this.maxBrp = maxBrp;
		this.predmet = predmet;
	}

	public int getPredispitneid() {
		return predispitneid;
	}

	public void setPredispitneid(int predispitneid) {
		this.predispitneid = predispitneid;
	}

	public VrstaObaveze getVrsta() {
		return vrsta;
	}

	public void setVrsta(VrstaObaveze vrsta) {
		this.vrsta = vrsta;
	}

	public int getMaxBrp() {
		return maxBrp;
	}

	public void setMaxBrp(int maxBrp) {
		this.maxBrp = maxBrp;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	}
