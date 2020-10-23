package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "slusaPredmet")
public class SlusaPredmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlusaPredmet;
	
	
	@ManyToOne
	@JoinColumn(name = "idStudent")
	private StudIndex index;
	
	@ManyToOne
	@JoinColumn(name = "idDrziPredmet")
	private DrziPredmet drziPredmet;

	public SlusaPredmet() {
		super();
	}

	public SlusaPredmet(StudIndex index, DrziPredmet drziPredmet) {
		super();
		this.index = index;
		this.drziPredmet = drziPredmet;

	}

	

	public DrziPredmet getDrziPredmet() {
		return drziPredmet;
	}

	public void setDrziPredmet(DrziPredmet drziPredmet) {
		this.drziPredmet = drziPredmet;
	}
	
	

}
