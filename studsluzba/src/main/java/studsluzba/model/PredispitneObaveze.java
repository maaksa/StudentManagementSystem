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
	private int predispitneid;

	private String vrstaObabeza;
	private int maxBrp;	
	

	public PredispitneObaveze() {
		super();
	}

	public PredispitneObaveze(int predispitneid, String vrstaObabeza, int maxBrp) {
		this.predispitneid = predispitneid;
		this.vrstaObabeza = vrstaObabeza;
		this.maxBrp = maxBrp;
	}

	public int getPredispitneid() {
		return predispitneid;
	}

	public void setPredispitneid(int predispitneid) {
		this.predispitneid = predispitneid;
	}


	public int getMaxBrp() {
		return maxBrp;
	}

	public void setMaxBrp(int maxBrp) {
		this.maxBrp = maxBrp;
	}

}
