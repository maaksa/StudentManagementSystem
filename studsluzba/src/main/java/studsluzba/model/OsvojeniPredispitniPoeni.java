package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "osvojeniPoeni")
public class OsvojeniPredispitniPoeni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOsvojeniPoeni;
    private int ukupanBrojPoena;

    @ManyToOne()
    @JoinColumn(name = "idStudIndex")
    private StudIndex studentIndeks;

    @OneToMany(mappedBy = "osvojeniPredispitniPoeni")
    private List<PredispitneObaveze> predIspitneObaveze;

    public OsvojeniPredispitniPoeni() {

    }

    public OsvojeniPredispitniPoeni(int ukupanBrojPoena, StudIndex studentIndeks) {
        this.ukupanBrojPoena = ukupanBrojPoena;
        this.studentIndeks = studentIndeks;
        predIspitneObaveze = new ArrayList<>();
    }

    public void addPredIspitne(PredispitneObaveze predObaveze) {
        if (predIspitneObaveze == null) {
            predIspitneObaveze = new ArrayList<>();
        }
        predIspitneObaveze.add(predObaveze);
        predObaveze.setOsvojeniPredispitniPoeni(this);
    }

    @Override
    public String toString() {
        return "OsvojeniPredispitniPoeni{" +
                "idOsvojeniPoeni=" + idOsvojeniPoeni +
                ", ukupanBrojPoena=" + ukupanBrojPoena +
                ", studentIndeks=" + studentIndeks +
                '}';
    }
}
