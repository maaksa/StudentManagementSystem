package studsluzba.model;

import java.util.List;

import javax.persistence.*;


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

    public String getVrstaObabeza() {
        return vrstaObabeza;
    }

    public void setVrstaObabeza(String vrstaObabeza) {
        this.vrstaObabeza = vrstaObabeza;
    }

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public int getMaxBrp() {
        return maxBrp;
    }

    public void setMaxBrp(int maxBrp) {
        this.maxBrp = maxBrp;
    }

    public SkolskaGodina getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public OsvojeniPredispitniPoeni getOsvojeniPredispitniPoeni() {
        return osvojeniPredispitniPoeni;
    }

    public void setOsvojeniPredispitniPoeni(OsvojeniPredispitniPoeni osvojeniPredispitniPoeni) {
        this.osvojeniPredispitniPoeni = osvojeniPredispitniPoeni;
    }

    public int getIdPredIspitne() {
        return idPredIspitne;
    }

    @Override
    public String toString() {
        return "PredispitneObaveze{" +
                "poeni=" + poeni +
                '}';
    }
}
