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

    //ne treba
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    @OneToMany(mappedBy = "ispit", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<IzlazakNaIspit> izlasciNaIspit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    @OneToMany(mappedBy = "ispit", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<PrijavaIspita> prijavaIspita;

    public Ispit() {

    }

    public Ispit(LocalDate datumOdrzavanja, Predmet predmet, Nastavnik nastavnik, String vremePocetka) {
        this.datumOdrzavanja = datumOdrzavanja;
        //this.predmet = predmet;
        this.nastavnik = nastavnik;
        this.vremePocetka = vremePocetka;
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

}
