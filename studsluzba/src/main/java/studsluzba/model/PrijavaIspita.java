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

    @OneToMany(mappedBy = "prijavaIspita", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<StudIndex> studIndexi;

    public PrijavaIspita() {
    }

    public PrijavaIspita(LocalDate datum, Ispit ispit) {
        this.datum = datum;
        this.ispit = ispit;
    }

    public void addStudIndex(StudIndex studIndex) {
        if (studIndexi == null) {
            studIndexi = new ArrayList<>();
        }
        studIndexi.add(studIndex);
        studIndex.setPrijavaIspita(this);
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

    public List<StudIndex> getStudIndexi() {
        return studIndexi;
    }

}
