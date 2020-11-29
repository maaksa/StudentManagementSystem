package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
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

    @OneToMany(mappedBy = "skolskaGod")
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
