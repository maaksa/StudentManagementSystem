package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ispitniRok")
public class IspitniRok {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspitniRok;

	private String datumPocetka;
	private String datumZavrsetka;

	@OneToMany
	@JoinColumn(name = "idIspit")
	private List<Ispit> ispiti;

	@ManyToOne
	@JoinColumn(name = "ispitniRokovi")
	private SkolskaGodina skolskaGod;

	public IspitniRok(String datumPocetka, String datumZavrsetka, List<Ispit> ispiti) {
		this.idIspitniRok = idIspitniRok;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		// this.ispiti = ispiti;
	}

	public IspitniRok() {

	}

	public int getIdIspitniRok() {
		return idIspitniRok;
	}

	public String getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public void addIspit(Ispit i) {
		if (ispiti == null) {
			ispiti = new ArrayList<>();
        }
		ispiti.add(i);
	}

}
