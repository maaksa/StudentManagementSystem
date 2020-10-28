package studsluzba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

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

    public Nastavnik(String ime, String prezime, String srednjeIme, String email, String obrazovanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.srednjeIme = srednjeIme;
        this.email = email;
        this.obrazovanje = obrazovanje;
    }

    public Nastavnik() {

    }

    public void addZvanje(Zvanje zvanje) {
        if (zvanja == null) {
            zvanja = new ArrayList<>();
        }
        zvanja.add(zvanje);
        zvanje.setNastavnik(this);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getSrednjeIme() {
        return srednjeIme;
    }

    public void setSrednjeIme(String srednjeIme) {
        this.srednjeIme = srednjeIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObrazovanje() {
        return obrazovanje;
    }

    public void setObrazovanje(String obrazovanje) {
        this.obrazovanje = obrazovanje;
    }

    public List<Zvanje> getZvanja() {
        return zvanja;
    }

    public void setZvanja(List<Zvanje> zvanja) {
        this.zvanja = zvanja;
    }

}
