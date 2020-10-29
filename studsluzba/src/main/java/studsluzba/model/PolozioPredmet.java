package studsluzba.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polozioPredmet")
public class PolozioPredmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPolozioPredmet;
    private int ocena;
    private float ukupanBrojPoena;
    private boolean priznatSaDrugogFaksa;

    //@OneToOne
    //@JoinColumn(name = "idVisokaSkola")
//	private VisokaSkola visokaSkola;

    //student indeks da bude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;

    //suvisno?  jedan ispit
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "polozioPredmet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Predmet> predmeti;


    public PolozioPredmet() {

    }

    public void addPredmet(Predmet predmet) {
        if (predmeti == null) {
            predmeti = new ArrayList<>();
        }
        predmeti.add(predmet);
        predmet.setPolozioPredmet(this);
    }

    public int getIdPolozioPredmet() {
        return idPolozioPredmet;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public StudIndex getStudent() {
        return studentIndex;
    }

    public StudIndex getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(StudIndex studentIndex) {
        this.studentIndex = studentIndex;
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    @Override
    public String toString() {
        return "PolozioPredmet{" +
                "idPolozioPredmet=" + idPolozioPredmet +
                ", ocena=" + ocena +
                ", ukupanBrojPoena=" + ukupanBrojPoena +
                ", priznatSaDrugogFaksa=" + priznatSaDrugogFaksa +
                ", studentIndex=" + studentIndex +
                ", predmeti=" + predmeti +
                '}';
    }
}
