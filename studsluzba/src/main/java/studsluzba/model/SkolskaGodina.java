package studsluzba.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "skolskaGodina")
public class SkolskaGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSkolskaGodina;
    private int datum;
    private boolean aktivna;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idObnovaGodina")
    private ObnovaGodina obnovaGodine;

    /* ODKOMENTARISATI
    @OneToMany
    @JoinColumn(name = "idIspitniRok")
    private List<IspitniRok> ispitniRokovi;
    */

    public SkolskaGodina() {
        super();
    }

    public int getIdSkolskaGodina() {
        return idSkolskaGodina;
    }
    /*
     * public List<Predmet> getPredemti() { return predemti; }
     *
     * public void setPredemti(List<Predmet> predemti) { this.predemti = predemti; }
     *
     * public List<Nastavnik> getNastavnici() { return nastavnici; }
     *
     * public void setNastavnici(List<Nastavnik> nastavnici) { this.nastavnici =
     * nastavnici; }
     */

    public int getDatum() {
        return datum;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    public boolean isAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    @Override
    public String toString() {
        return "SkolskaGodina{" +
                "datum=" + datum +
                '}';
    }
}
