package studsluzba.model;

import java.time.LocalDate;
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
	
/*	@OneToMany
	@JoinColumn(name = "idPredmet")
	private List<Predmet> predmetPrenos;*/

    private int datum;
    private String napomena;


    public UpisGodina() {

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
        return '{' +
                "datum=" + datum +
                '}' + '\n';
    }
}
