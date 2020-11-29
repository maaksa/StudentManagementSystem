package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "zvanje")
public class Zvanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZvanje;

    private LocalDate datumIzbora;
    private String uzaNaucnaOblast;
    private String nazivZvanja;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    public Zvanje() {
    }

    public Zvanje(LocalDate datumIzbora, String uzaNaucnaOblast, String nazivZvanja) {
        this.datumIzbora = datumIzbora;
        this.uzaNaucnaOblast = uzaNaucnaOblast;
        this.nazivZvanja = nazivZvanja;
    }

    @Override
    public String toString() {
        return "Zvanje{" +
                "idZvanje=" + idZvanje +
                ", datumIzbora=" + datumIzbora +
                ", uzaNaucnaOblast='" + uzaNaucnaOblast + '\'' +
                ", nazivZvanja='" + nazivZvanja + '\'' +
                ", nastavnik=" + nastavnik +
                '}';
    }
}
