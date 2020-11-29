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
@Table(name = "studIndex")
public class StudIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudIndex;

    private int broj;
    private int godina;
    private boolean aktivan;
    private LocalDate odKadJeAktivan;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idStudent")
    private Student student;

    @OneToMany(mappedBy = "studIndexi", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<PrijavaIspita> prijavaIspita;

    @OneToMany(mappedBy = "studentIndex", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<UpisGodina> upisGodina;

    @OneToMany(mappedBy = "studentIndeks", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<ObnovaGodina> obnovljeneGodine;

    @OneToMany(mappedBy = "studentIndex", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<PolozioPredmet> polozioPredmete;

    @OneToMany(mappedBy = "studentIndeks", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<OsvojeniPredispitniPoeni> predIspitne;

    @OneToMany(mappedBy = "index", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<SlusaPredmet> slusaPredmete;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idstudProgram")
    private StudProgram studProgram;

    public StudIndex(int broj, int godina, boolean aktivan, LocalDate odKadJeAktivan, Student student, StudProgram studProgram) {
        this.broj = broj;
        this.godina = godina;
        this.aktivan = aktivan;
        this.odKadJeAktivan = odKadJeAktivan;
        this.student = student;
        this.studProgram = studProgram;
        slusaPredmete = new ArrayList<>();
        predIspitne = new ArrayList<>();
        polozioPredmete = new ArrayList<>();
        obnovljeneGodine = new ArrayList<>();
        upisGodina = new ArrayList<>();
    }

    public StudIndex() {

    }



    public void addPrijavaIspita(PrijavaIspita prijava) {
        if (prijavaIspita == null) {
            prijavaIspita = new ArrayList<>();
        }
        prijavaIspita.add(prijava);
        prijava.setStudIndexi(this);
    }

    public void addSlusaPred(SlusaPredmet slusa) {
        if (slusaPredmete == null) {
            slusaPredmete = new ArrayList<>();
        }
        slusaPredmete.add(slusa);
        slusa.setIndex(this);
    }

    public void addOsvojeniPoeni(OsvojeniPredispitniPoeni poeniOsvojeni) {
        if (predIspitne == null) {
            predIspitne = new ArrayList<>();
        }
        predIspitne.add(poeniOsvojeni);
        poeniOsvojeni.setStudentIndeks(this);
    }

    public void addPolozioPredmet(PolozioPredmet polozioPredmet) {
        if (polozioPredmete == null) {
            polozioPredmete = new ArrayList<>();
        }
        polozioPredmete.add(polozioPredmet);
        polozioPredmet.setStudentIndex(this);
    }

    public void addUpisGodina(UpisGodina upisGodine) {
        if (upisGodina == null) {
            upisGodina = new ArrayList<>();
        }
        upisGodina.add(upisGodine);
        upisGodine.setStudentIndex(this);
    }

    public void addObnovaGodine(ObnovaGodina obnovaGodina) {
        if (obnovljeneGodine == null) {
            obnovljeneGodine = new ArrayList<>();
        }
        obnovljeneGodine.add(obnovaGodina);
        obnovaGodina.setStudentIndeks(this);
    }

    @Override
    public String toString() {
        return "StudIndex{" +
                "broj=" + broj +
                ", godina=" + godina +
                ", aktivan=" + aktivan +
                ", odKadJeAktivan=" + odKadJeAktivan +
                ", student=" + student +
                ", studProgram=" + studProgram +
                '}';
    }
}
