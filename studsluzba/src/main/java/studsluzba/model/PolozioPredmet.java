package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "polozioPredmet")
public class PolozioPredmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPolozioPredmet;
    private int ocena;
    private float ukupanBrojPoena;
    private boolean priznatSaDrugogFaksa;

    //student indeks da bude
    @ManyToOne()
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;

    //suvisno?  jedan ispit
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "polozioPredmet")
    private List<Predmet> predmeti;

    //izlazak na ispit da ima idIzlazak
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idIzlazak")
    private IzlazakNaIspit izlazakNaIspit;

    public PolozioPredmet() {

    }

    public PolozioPredmet(int ocena, float ukupanBrojPoena, boolean priznatSaDrugogFaksa, StudIndex studentIndex) {
        this.ocena = ocena;
        this.ukupanBrojPoena = ukupanBrojPoena;
        this.priznatSaDrugogFaksa = priznatSaDrugogFaksa;
        this.studentIndex = studentIndex;
    }

    @Override
    public String toString() {
        return this.getPredmeti().toString();
    }
}
