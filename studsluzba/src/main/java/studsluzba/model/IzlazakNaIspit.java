package studsluzba.model;

import javax.persistence.*;

@Entity
@Table(name = "izlazakIspit")
public class IzlazakNaIspit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIzlazak;

    private int brojOsvojenihPoena;
    private String napomena;
    private boolean ponistavanje;
    private boolean izasaoNaIspit;

    // proveriti
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPrijava")
    private PrijavaIspita prijavljenIspit;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idIspit")
    private Ispit ispit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPolozioPredmet")
    private PolozioPredmet polozioPredmet;

    public IzlazakNaIspit() {

    }

    public IzlazakNaIspit(int brojOsvojenihPoena, String napomena, boolean ponistavanje, boolean izasaoNaIspit, PrijavaIspita prijavljenIspit, Ispit ispit) {
        this.brojOsvojenihPoena = brojOsvojenihPoena;
        this.napomena = napomena;
        this.ponistavanje = ponistavanje;
        this.izasaoNaIspit = izasaoNaIspit;
        this.prijavljenIspit = prijavljenIspit;
        this.ispit = ispit;
    }

    public int getIdIzlazak() {
        return idIzlazak;
    }

    public int getBrojOsvojenihPoena() {
        return brojOsvojenihPoena;
    }

    public void setBrojOsvojenihPoena(int brojOsvojenihPoena) {
        this.brojOsvojenihPoena = brojOsvojenihPoena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public boolean isPonistavanje() {
        return ponistavanje;
    }

    public void setPonistavanje(boolean ponistavanje) {
        this.ponistavanje = ponistavanje;
    }

    public PrijavaIspita getPrijavljenIspit() {
        return prijavljenIspit;
    }

    public void setPrijavljenIspit(PrijavaIspita prijavljenIspit) {
        this.prijavljenIspit = prijavljenIspit;
    }

    public boolean isIzasaoNaIspit() {
        return izasaoNaIspit;
    }

    public void setIzasaoNaIspit(boolean izasaoNaIspit) {
        this.izasaoNaIspit = izasaoNaIspit;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public PolozioPredmet getPolozioPredmet() {
        return polozioPredmet;
    }

    public void setPolozioPredmet(PolozioPredmet polozioPredmet) {
        this.polozioPredmet = polozioPredmet;
    }

    @Override
    public String toString() {
        return "IzlazakNaIspit{" +
                "idIzlazak=" + idIzlazak +
                ", brojOsvojenihPoena=" + brojOsvojenihPoena +
                ", napomena='" + napomena + '\'' +
                ", ponistavanje=" + ponistavanje +
                ", izasaoNaIspit=" + izasaoNaIspit +
                ", prijavljenIspit=" + prijavljenIspit +
                ", ispit=" + ispit +
                '}';
    }
}
