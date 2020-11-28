package studsluzba.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "srednjaSkola")
public class SrednjaSkola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSrednjaSkola;

    private String naziv;
    private String mesto;
    private String vrsta;

    @OneToMany(mappedBy = "srednjaSkola", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Student> studenti;

    public SrednjaSkola() {

    }

    public SrednjaSkola(String naziv, String mesto, String vrsta) {
        this.naziv = naziv;
        this.mesto = mesto;
        this.vrsta = vrsta;
        studenti = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (studenti == null) {
            studenti = new ArrayList<>();
        }
        studenti.add(student);
        student.setSrednjaSkola(this);
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public int getIdSrednjaSkola() {
        return idSrednjaSkola;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String toString() {
        return naziv + ", " + mesto + "," + vrsta;
    }

}
