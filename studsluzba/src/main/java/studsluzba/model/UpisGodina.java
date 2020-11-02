package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "upisGodina")
public class UpisGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUpisGodina;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGodina;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;
	

    private int datum;
    private String napomena;


    public UpisGodina() {

    }

    public UpisGodina(SkolskaGodina skolskaGodina, StudIndex studentIndex, int datum, String napomena) {
        this.skolskaGodina = skolskaGodina;
        this.studentIndex = studentIndex;
        this.datum = datum;
        this.napomena = napomena;
        //predmetPrenos  = new ArrayList<>();
    }

    public StudIndex getStudentIndex() {
        return studentIndex;
    }

    public int getIdUpisGodina() {
        return idUpisGodina;
    }

    public SkolskaGodina getSkolskaGodina() {
        return skolskaGodina;
    }


    public void setStudentIndex(StudIndex studentIndex) {
        this.studentIndex = studentIndex;
    }

    public void setSkolskaGodina(SkolskaGodina skolskaGodina) {
        this.skolskaGodina = skolskaGodina;
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
        return "UpisGodina{" +
                "datum=" + datum +
                '}';
    }
}
