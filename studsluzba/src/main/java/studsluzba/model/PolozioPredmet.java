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

    //student indeks da bude
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;

    //suvisno?  jedan ispit
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "polozioPredmet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
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
        predmeti = new ArrayList<>();
    }

    public void addPredmet(Predmet predmet) {
        if (predmeti == null) {
            predmeti = new ArrayList<>();
        }
        predmeti.add(predmet);
        predmet.setPolozioPredmet(this);
    }

    public void setPriznatSaDrugogFaksa(boolean priznatSaDrugogFaksa) {
        this.priznatSaDrugogFaksa = priznatSaDrugogFaksa;
    }

    public float getUkupanBrojPoena() {
        return ukupanBrojPoena;
    }

    public void setUkupanBrojPoena(float ukupanBrojPoena) {
        this.ukupanBrojPoena = ukupanBrojPoena;
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

    public IzlazakNaIspit getIzlazakNaIspit() {
        return izlazakNaIspit;
    }

    public void setIzlazakNaIspit(IzlazakNaIspit izlazakNaIspit) {
        this.izlazakNaIspit = izlazakNaIspit;
    }

    @Override
    public String toString() {
        return "PolozioPredmet{" +
                "idPolozioPredmet=" + idPolozioPredmet +
                ", ocena=" + ocena +
                ", ukupanBrojPoena=" + ukupanBrojPoena +
                ", priznatSaDrugogFaksa=" + priznatSaDrugogFaksa +
                ", studentIndex=" + studentIndex +
                '}';
    }
}
