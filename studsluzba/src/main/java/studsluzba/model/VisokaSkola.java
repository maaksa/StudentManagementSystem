package studsluzba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class VisokaSkola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVisokaSkola;
	private String naziv;

	public VisokaSkola() {
		super();
	}

	public int getIdVisokaSkola() {
		return idVisokaSkola;
	}

	public void setIdVisokaSkola(int idVisokaSkola) {
		this.idVisokaSkola = idVisokaSkola;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
