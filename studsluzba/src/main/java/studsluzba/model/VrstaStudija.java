package studsluzba.model;

import javax.persistence.*;

@Entity
@Table(name="vrstaStudija")
public class VrstaStudija 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVrstaStudija;
	
	private String punNaziv;
	private String skraceniNaziv;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;
	
	public VrstaStudija() {
		super();
	}

	public VrstaStudija(int vrstaStudijaid, String punNaziv, String skraceniNaziv) 
	{
		super();
		this.idVrstaStudija = vrstaStudijaid;
		this.punNaziv = punNaziv;
		this.skraceniNaziv = skraceniNaziv;
	}

	public int getVrstaStudijaid() {
		return idVrstaStudija;
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

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}

	public StudProgram getStudProgram() {
		return studProgram;
	}
}
