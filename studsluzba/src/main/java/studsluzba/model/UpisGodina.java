package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "upisGodina")
public class UpisGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUpisGodina;

    @ManyToOne()
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGodina;


    @ManyToOne()
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;
	
/*	@OneToMany
	@JoinColumn(name = "idPredmet")
	private List<Predmet> predmetPrenos;*/

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

    @Override
    public String toString() {
        return "UpisGodina{" +
                "datum=" + datum +
                '}';
    }
}
