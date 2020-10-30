package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "obnovaGodine")
public class ObnovaGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObnovaGodina;

    private int datum;
    private String napomena;

    //indeks
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndeks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGodina;

    @OneToMany(mappedBy = "obnova", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Predmet> predmetPrenos;

    public ObnovaGodina() {

    }

    public ObnovaGodina(int datum, String napomena, StudIndex studentIndeks, SkolskaGodina skolskaGodina) {
        this.datum = datum;
        this.napomena = napomena;
        this.studentIndeks = studentIndeks;
        this.skolskaGodina = skolskaGodina;
        predmetPrenos = new ArrayList<>();
    }

    public void addPredmetPrenos(Predmet predmet) {
        if (predmetPrenos == null) {
            predmetPrenos = new ArrayList<>();
        }
        predmetPrenos.add(predmet);
        predmet.setObnova(this);
    }

    public StudIndex getStudentIndeks() {
        return studentIndeks;
    }

    public int getIdObnovaGodina() {
        return idObnovaGodina;
    }

    public StudIndex getStudentIndex() {
        return studentIndeks;
    }

    public void setStudentIndex(StudIndex studentIndeks) {
        this.studentIndeks = studentIndeks;
    }

    public SkolskaGodina getSkolskaGodina() {
        return skolskaGodina;
    }

    public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
    }

    public List<Predmet> getPredmetPrenos() {
        return predmetPrenos;
    }

    public void setPredmetPrenos(List<Predmet> predmetPrenos) {
        this.predmetPrenos = predmetPrenos;
    }

    public void setStudentIndeks(StudIndex studentIndeks) {
        this.studentIndeks = studentIndeks;
    }

    public int getDatum() {
        return datum;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "ObnovaGodina{" +
                "idObnovaGodina=" + idObnovaGodina +
                ", datum=" + datum +
                ", napomena='" + napomena + '\'' +
                ", studentIndeks=" + studentIndeks +
                ", skolskaGodina=" + skolskaGodina +
                '}';
    }
}
