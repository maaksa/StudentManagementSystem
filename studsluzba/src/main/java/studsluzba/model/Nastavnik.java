package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "nastavnik")
public class Nastavnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNastavnik;

    private String ime;
    private String prezime;
    private String srednjeIme;
    private String email;
    private String obrazovanje;

    @OneToMany(mappedBy = "nastavnik", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Zvanje> zvanja;

    @OneToMany(mappedBy = "nastavnik", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<DrziPredmet> drziPredmet;

    public Nastavnik(String ime, String prezime, String srednjeIme, String email, String obrazovanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.srednjeIme = srednjeIme;
        this.email = email;
        this.obrazovanje = obrazovanje;
        drziPredmet = new ArrayList<>();
        zvanja = new ArrayList<>();
    }

    public Nastavnik() {

    }

    public void addDrziPredmet(DrziPredmet drzi) {
        if (drziPredmet == null) {
            drziPredmet = new ArrayList<>();
        }
        drziPredmet.add(drzi);
        drzi.setNastavnik(this);
    }

    public void addZvanje(Zvanje zvanje) {
        if (zvanja == null) {
            zvanja = new ArrayList<>();
        }
        zvanja.add(zvanje);
        zvanje.setNastavnik(this);
    }

    @Override
    public String toString() {
        return "Nastavnik{" +
                "idNastavnik=" + idNastavnik +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", srednjeIme='" + srednjeIme + '\'' +
                ", email='" + email + '\'' +
                ", obrazovanje='" + obrazovanje + '\'' +
                '}';
    }
}
