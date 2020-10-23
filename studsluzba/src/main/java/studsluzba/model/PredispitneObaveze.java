package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "predispitneObaveze")
public class PredispitneObaveze {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredIspitne;

	private String vrstaObabeza;
	private int poeni;	
	

	public PredispitneObaveze() {
		super();
	}

	public PredispitneObaveze(int predispitneid, String vrstaObabeza, int maxBrp) {
		this.idPredIspitne = predispitneid;
		this.vrstaObabeza = vrstaObabeza;
		this.poeni = maxBrp;
	}

	public int getPredispitneid() {
		return idPredIspitne;
	}

	public void setPredispitneid(int predispitneid) {
		this.idPredIspitne = predispitneid;
	}


	public int getMaxBrp() {
		return poeni;
	}

	public void setMaxBrp(int maxBrp) {
		this.poeni = maxBrp;
	}

}
