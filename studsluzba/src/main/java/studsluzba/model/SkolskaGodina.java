package studsluzba.model;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "skolskaGod", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<IspitniRok> ispitniRokovi;

    public SkolskaGodina() {

    }

    public SkolskaGodina(int datum, boolean aktivna, ObnovaGodina obnovaGodine) {
        this.datum = datum;
        this.aktivna = aktivna;
        this.obnovaGodine = obnovaGodine;
        ispitniRokovi = new ArrayList<>();
    }

    public void addIspitniRok(IspitniRok ispitniRok) {
        if (ispitniRokovi == null) {
            ispitniRokovi = new ArrayList<>();
        }
        ispitniRokovi.add(ispitniRok);
        ispitniRok.setSkolskaGod(this);
    }

    public int getIdSkolskaGodina() {
        return idSkolskaGodina;
    }

    public List<IspitniRok> getIspitniRokovi() {
        return ispitniRokovi;
    }

    public ObnovaGodina getObnovaGodine() {
        return obnovaGodine;
    }

    public void setObnovaGodine(ObnovaGodina obnovaGodine) {
        this.obnovaGodine = obnovaGodine;
    }

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
                "idSkolskaGodina=" + idSkolskaGodina +
                ", datum=" + datum +
                ", aktivna=" + aktivna +
                ", obnovaGodine=" + obnovaGodine +
                '}';
    }
}
