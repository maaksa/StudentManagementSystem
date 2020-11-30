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
@Table(name = "obnovaGodine")
public class ObnovaGodina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idObnovaGodina;

    private int datum;
    private String napomena;

    //indeks
    @ManyToOne()
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndeks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGodina;

    @OneToMany(mappedBy = "obnova")
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

    @Override
    public String toString() {
        return "godina: " + getSkolskaGodina().getDatum()+"/" + (getSkolskaGodina().getDatum()+1)%1000;
    }
}
