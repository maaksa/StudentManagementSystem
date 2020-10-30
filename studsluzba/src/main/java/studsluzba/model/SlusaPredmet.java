package studsluzba.model;

import javax.persistence.*;

@Entity
@Table(name = "slusaPredmet")
public class SlusaPredmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSlusaPredmet;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudent")
    private StudIndex index;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idDrziPredmet")
    private DrziPredmet drziPredmet;

    public SlusaPredmet() {

    }

    public SlusaPredmet(StudIndex index, DrziPredmet drziPredmet) {
        this.index = index;
        this.drziPredmet = drziPredmet;
    }

    public int getIdSlusaPredmet() {
        return idSlusaPredmet;
    }

    public DrziPredmet getDrziPredmet() {
        return drziPredmet;
    }

    public void setDrziPredmet(DrziPredmet drziPredmet) {
        this.drziPredmet = drziPredmet;
    }

    public StudIndex getIndex() {
        return index;
    }

    public void setIndex(StudIndex index) {
        this.index = index;
    }


}
