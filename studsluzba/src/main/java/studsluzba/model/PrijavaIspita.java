package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "prijavaIspit")
public class PrijavaIspita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrijava;
    private LocalDate datum;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idIspit")
    private Ispit ispit;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudIndex")
    private StudIndex studIndexi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idIzlazak")
    private IzlazakNaIspit izlazakNaIspit;

    public PrijavaIspita() {
    }


    public PrijavaIspita(LocalDate datum, Ispit ispit) {
        this.datum = datum;
        this.ispit = ispit;

    }


    public int getIdPrijava() {
        return idPrijava;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public StudIndex getStudIndexi() {
        return studIndexi;
    }

    public void setStudIndexi(StudIndex studIndexi) {
        this.studIndexi = studIndexi;
    }

    public IzlazakNaIspit getIzlazakNaIspit() {
        return izlazakNaIspit;
    }

    public void setIzlazakNaIspit(IzlazakNaIspit izlazakNaIspit) {
        this.izlazakNaIspit = izlazakNaIspit;
    }
}
