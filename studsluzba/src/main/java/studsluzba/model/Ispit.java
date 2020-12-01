package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ispit")
public class Ispit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIspit;

    private String sifraIspita;
    private LocalDate datumOdrzavanja;
    private String vremePocetka;
    private boolean unetiPoeni;


    @ManyToOne()
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    @ManyToOne()
    @JoinColumn(name = "idIspitniRok")
    private IspitniRok ispitniRok;

    @OneToMany(mappedBy = "ispit")
    private List<IzlazakNaIspit> izlasciNaIspit;

    @OneToOne()
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    @OneToMany(mappedBy = "ispit")
    private List<PrijavaIspita> prijavaIspita;

    public Ispit() {

    }

    public Ispit(String sifraIspita, LocalDate datumOdrzavanja, String vremePocetka, boolean unetiPoeni, Predmet predmet, IspitniRok ispitniRok, Nastavnik nastavnik) {
        this.sifraIspita = sifraIspita;
        this.datumOdrzavanja = datumOdrzavanja;
        this.vremePocetka = vremePocetka;
        this.unetiPoeni = unetiPoeni;
        this.predmet = predmet;
        this.ispitniRok = ispitniRok;
        this.nastavnik = nastavnik;
    }

    @Override
    public String toString() {
        return "Ispit{" +
                "idIspit=" + idIspit +
                ", sifraIspita='" + sifraIspita + '\'' +
                ", datumOdrzavanja=" + datumOdrzavanja +
                ", vremePocetka='" + vremePocetka + '\'' +
                ", unetiPoeni=" + unetiPoeni +
                ", predmet=" + predmet +
                ", ispitniRok=" + ispitniRok +
                ", nastavnik=" + nastavnik +
                '}';
    }
}
