package studsluzba.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "predmet")
public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String sifraPredmeta;
	private String nazivPredmeta;
	private String opis;
	private int brojESPB;
	private int fondPredavanja;
	private int fondVezbi;

	private int brojSemestra;			

	@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;

	public Predmet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getBrojESPB() {
		return brojESPB;
	}

	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}

	public int getFondPredavanja() {
		return fondPredavanja;
	}

	public void setFondPredavanja(int fondPredavanja) {
		this.fondPredavanja = fondPredavanja;
	}

	public int getFondVezbi() {
		return fondVezbi;
	}

	public void setFondVezbi(int fondVezbi) {
		this.fondVezbi = fondVezbi;
	}

	public int getBrojSemestra() {
		return brojSemestra;
	}

	public void setBrojSemestra(int brojSemestra) {
		this.brojSemestra = brojSemestra;
	}

	public StudProgram getStudProgram() {
		return studProgram;
	}

	public void setStudProgram(StudProgram studProgram) {
		this.studProgram = studProgram;
	}
}
