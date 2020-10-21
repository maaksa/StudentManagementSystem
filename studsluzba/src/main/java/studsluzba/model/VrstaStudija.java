package studsluzba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vrstaStudija")
public class VrstaStudija 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vrstaStudijaid;
	
	private String punNaziv;
	private String skraceniNaziv;
	
	
	
	public VrstaStudija() {
		super();
	}

	public VrstaStudija(int vrstaStudijaid, String punNaziv, String skraceniNaziv) 
	{
		super();
		this.vrstaStudijaid = vrstaStudijaid;
		this.punNaziv = punNaziv;
		this.skraceniNaziv = skraceniNaziv;
	}

	public int getVrstaStudijaid() {
		return vrstaStudijaid;
	}

	public void setVrstaStudijaid(int vrstaStudijaid) {
		this.vrstaStudijaid = vrstaStudijaid;
	}

	public String getPunNaziv() {
		return punNaziv;
	}

	public void setPunNaziv(String punNaziv) {
		this.punNaziv = punNaziv;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	
	
}
