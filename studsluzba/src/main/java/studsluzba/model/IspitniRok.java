package studsluzba.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ispitniRok")
public class IspitniRok {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIspitniRok;

	private LocalDate datumPocetka;
	private LocalDate datumZavrsetka;
	private List<Ispit> ispiti;
	private SkolskaGodina skolskaGod;

	public IspitniRok(int idIspitniRok, LocalDate datumPocetka, LocalDate datumZavrsetka, List<Ispit> ispiti) {
		this.idIspitniRok = idIspitniRok;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.ispiti = ispiti;
	}

	public int getIdIspitniRok() {
		return idIspitniRok;
	}

	public void setIdIspitniRok(int idIspitniRok) {
		this.idIspitniRok = idIspitniRok;
	}

	public LocalDate getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(LocalDate datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public LocalDate getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(LocalDate datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public List<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(List<Ispit> ispiti) {
		this.ispiti = ispiti;
	}
	public SkolskaGodina getSkolskaGod() {
		return skolskaGod;
	}
	public void setSkolskaGod(SkolskaGodina skolskaGod) {
		this.skolskaGod = skolskaGod;
	}
}
