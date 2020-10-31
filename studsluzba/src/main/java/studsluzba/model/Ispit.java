package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idIspitniRok")
    private IspitniRok ispitniRok;

    @OneToMany(mappedBy = "ispit", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<IzlazakNaIspit> izlasciNaIspit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    @OneToMany(mappedBy = "ispit", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
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
        prijavaIspita = new ArrayList<>();
        izlasciNaIspit = new ArrayList<>();
    }

    public void addPrijavaIspita(PrijavaIspita prijava) {
        if (prijavaIspita == null) {
            prijavaIspita = new ArrayList<>();
        }
        prijavaIspita.add(prijava);
        prijava.setIspit(this);
    }

    public void addIzlazakNaIspit(IzlazakNaIspit izlazakNaIspit) {
        if (izlasciNaIspit == null) {
            izlasciNaIspit = new ArrayList<>();
        }
        izlasciNaIspit.add(izlazakNaIspit);
        izlazakNaIspit.setIspit(this);
    }

    public IspitniRok getIspitniRok() {
        return ispitniRok;
    }

    public List<IzlazakNaIspit> getIzlasciNaIspit() {
        return izlasciNaIspit;
    }

    public List<PrijavaIspita> getPrijavaIspita() {
        return prijavaIspita;
    }

    public int getIdIspit() {
        return idIspit;
    }

    public LocalDate getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public void setIdIspit(int idIspit) {
        this.idIspit = idIspit;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public String getVremePocetka() {
        return vremePocetka;
    }

    public void setVremePocetka(String vremePocetka) {
        this.vremePocetka = vremePocetka;
    }

    public boolean isUnetiPoeni() {
        return unetiPoeni;
    }

    public void setUnetiPoeni(boolean unetiPoeni) {
        this.unetiPoeni = unetiPoeni;
    }

    public String getSifraIspita() {
        return sifraIspita;
    }

    public void setSifraIspita(String sifraIspita) {
        this.sifraIspita = sifraIspita;
    }

    public void setIspitniRok(IspitniRok ispitniRok) {
        this.ispitniRok = ispitniRok;
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
