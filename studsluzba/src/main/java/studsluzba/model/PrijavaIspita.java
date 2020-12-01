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
@Table(name = "prijavaIspit")
public class PrijavaIspita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrijava;
    private LocalDate datum;

    @ManyToOne()
    @JoinColumn(name = "idIspit")
    private Ispit ispit;


    @ManyToOne()
    @JoinColumn(name = "idStudIndex")
    private StudIndex studIndexi;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idIzlazak")
    private IzlazakNaIspit izlazakNaIspit;

    public PrijavaIspita() {
    }


    public PrijavaIspita(LocalDate datum, Ispit ispit) {
        this.datum = datum;
        this.ispit = ispit;
    }

}
