package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "drziPredmet")
public class DrziPredmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDrziPredmet;
    private String sifra;

    @ManyToOne()
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    @ManyToOne()
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    @ManyToOne()
    @JoinColumn(name = "idSkolskaGodina")
    private SkolskaGodina skolskaGod;

    @OneToMany(mappedBy = "drziPredmet")
    private List<SlusaPredmet> slusaPredmet;

    public DrziPredmet() {

    }

    public DrziPredmet(String sifra, Predmet predmet, Nastavnik nastavnik, SkolskaGodina skolskaGod) {
        this.sifra = sifra;
        this.predmet = predmet;
        this.nastavnik = nastavnik;
        this.skolskaGod = skolskaGod;
    }

}
