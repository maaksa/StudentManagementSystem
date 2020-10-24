package studsluzba.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "studIndex")
public class StudIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudIndex;

 /*   @ManyToOne(cascade = CascadeType.ALL)
    private StudProgram program;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idStudent")
    private Student student;

    private int broj;
    private int godina;
    private boolean aktivan;
    private LocalDate odKadJeAktivan;

    @OneToMany(mappedBy = "studentIndex", cascade = CascadeType.ALL)
    private List<PolozioPredmet> polozioPredmete;

    public StudIndex(int broj, int godina, StudProgram program, boolean aktivan, LocalDate odKadJeAktivan) {
        this.broj = broj;
        this.godina = godina;
        //this.program = program;
        this.aktivan = aktivan;
        this.odKadJeAktivan = odKadJeAktivan;
    }

    public StudIndex() {

    }

    public void addPolozioPredmet(PolozioPredmet polozioPredmet) {
        if (polozioPredmete == null) {
            polozioPredmete = new ArrayList<>();
        }
        polozioPredmete.add(polozioPredmet);
        polozioPredmet.setStudentIndex(this);
    }

    public int getIdStudIndex() {
        return idStudIndex;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

/*    public StudProgram getProgram() {
        return program;
    }

    public void setProgram(StudProgram program) {
        this.program = program;
    }*/

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public LocalDate getOdKadJeAktivan() {
        return odKadJeAktivan;
    }

    public void setOdKadJeAktivan(LocalDate odKadJeAktivan) {
        this.odKadJeAktivan = odKadJeAktivan;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Studentski index = [id = " + idStudIndex + ", broj =  " + broj + ", godina = " + godina
                + ", studijski program " /*+ program.getSkraceniNaziv()*/ + ", aktivan od = " + odKadJeAktivan;
    }

}
