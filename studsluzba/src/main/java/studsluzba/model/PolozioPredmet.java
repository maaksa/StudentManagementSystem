package studsluzba.model;

import javax.persistence.*;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndex;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPredmet")
    private Predmet predmet;

    public PolozioPredmet() {

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

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }
}
