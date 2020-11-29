package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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


}
