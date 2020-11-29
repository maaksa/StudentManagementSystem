package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "predispitneObaveze")
public class PredispitneObaveze {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPredIspitne;

    private String vrstaObabeza;
    private int poeni;
    private int maxBrp;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGodina;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idOsvojeniPoeni")
    private OsvojeniPredispitniPoeni osvojeniPredispitniPoeni;


    public PredispitneObaveze() {
    }

    public PredispitneObaveze(String vrstaObabeza, int poeni, int maxBrp, SkolskaGodina skolskaGodina, Predmet predmet, OsvojeniPredispitniPoeni osvojeniPredispitniPoeni) {
        this.vrstaObabeza = vrstaObabeza;
        this.poeni = poeni;
        this.maxBrp = maxBrp;
        this.skolskaGodina = skolskaGodina;
        this.predmet = predmet;
        this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
    }

    @Override
    public String toString() {
        return "PredispitneObaveze{" +
                "poeni=" + poeni +
                '}';
    }
}
