package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zvanje")
public class Zvanje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Zvanjeid;

	private LocalDate datumIzbora;
	private String uzaNaucnaOblast;
	private String nazivZvanja;

	public Zvanje(int zvanjeid, LocalDate datumIzbora, String uzaNaucnaOblast, String nazivZvanja)
	{
		Zvanjeid = zvanjeid;
		this.datumIzbora = datumIzbora;
		this.uzaNaucnaOblast = uzaNaucnaOblast;
		this.nazivZvanja = nazivZvanja;
	}

	public int getZvanjeid() {
		return Zvanjeid;
	}

	public void setZvanjeid(int zvanjeid) {
		Zvanjeid = zvanjeid;
	}

	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDate datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public String getUzaNaucnaOblast() {
		return uzaNaucnaOblast;
	}

	public void setUzaNaucnaOblast(String uzaNaucnaOblast) {
		this.uzaNaucnaOblast = uzaNaucnaOblast;
	}

	public String getNazivZvanja() {
		return nazivZvanja;
	}

	public void setNazivZvanja(String nazivZvanja) {
		this.nazivZvanja = nazivZvanja;
	}
	

}
