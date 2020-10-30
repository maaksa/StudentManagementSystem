package studsluzba.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "visokaSkola")
public class VisokaSkola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVisokaSkola;

    private String naziv;
    private String mesto;
    private String vrsta;

    @OneToMany(mappedBy = "visokaSkola", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Student> studentii;

    public VisokaSkola() {
    }

    public VisokaSkola(String naziv, String mesto, String vrsta) {
        this.naziv = naziv;
        this.mesto = mesto;
        this.vrsta = vrsta;
        studentii = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (studentii == null) {
            studentii = new ArrayList<>();
        }
        studentii.add(student);
        student.setVisokaSkola(this);
    }

    public void setStudentii(List<Student> studentii) {
        this.studentii = studentii;
    }

    public List<Student> getStudentii() {
        return studentii;
    }

    public String getMesto() {
        return mesto;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public void setStudenti(List<Student> studenti) {
        this.studentii = studenti;
    }

    public List<Student> getStudenti() {
        return studentii;
    }

    public int getIdVisokaSkola() {
        return idVisokaSkola;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "VisokaSkola{" +
                "idVisokaSkola=" + idVisokaSkola +
                ", naziv='" + naziv + '\'' +
                ", mesto='" + mesto + '\'' +
                ", vrsta='" + vrsta + '\'' +
                '}';
    }
}
