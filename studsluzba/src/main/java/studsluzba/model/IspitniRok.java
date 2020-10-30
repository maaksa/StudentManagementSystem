package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ispitniRok")
public class IspitniRok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIspitniRok;

    private String datumPocetka;
    private String datumZavrsetka;

    @OneToMany(mappedBy = "ispitniRok", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Ispit> ispiti;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGod;

    public IspitniRok(String datumPocetka, String datumZavrsetka, SkolskaGodina skolskaGod) {
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.skolskaGod = skolskaGod;
        ispiti = new ArrayList<>();
    }

    public IspitniRok() {

    }

    public void addIspit(Ispit i) {
        if (ispiti == null) {
            ispiti = new ArrayList<>();
        }
        ispiti.add(i);
        i.setIspitniRok(this);
    }

    public SkolskaGodina getSkolskaGod() {
        return skolskaGod;
    }

    public void setSkolskaGod(SkolskaGodina skolskaGod) {
        this.skolskaGod = skolskaGod;
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

    @Override
    public String toString() {
        return "IspitniRok{" +
                "idIspitniRok=" + idIspitniRok +
                ", datumPocetka='" + datumPocetka + '\'' +
                ", datumZavrsetka='" + datumZavrsetka + '\'' +
                ", skolskaGod=" + skolskaGod +
                '}';
    }
}
