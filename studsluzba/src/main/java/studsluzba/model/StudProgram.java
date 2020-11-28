package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the studProgram database table.
 */
@Entity
@Table(name = "studProgram")
//@NamedQuery(name = "StudProgram.findAll", query = "SELECT s FROM StudProgram s")
public class StudProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idstudProgram;

    private String naziv;
    private String skraceniNaziv;
    private LocalDate godinaAkreditacije;
    private int trajanje;
    private String nazivZvanja;

    @OneToMany(mappedBy = "studProgram", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<VrstaStudija> vrsteStudija;

    @OneToMany(mappedBy = "studProgram", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<StudIndex> studIndexi;

    @OneToMany(mappedBy = "studProgram", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Predmet> predmeti;

    public StudProgram() {
    }

    public StudProgram(String naziv, String skraceniNaziv, LocalDate godinaAkreditacije, int trajanje, String nazivZvanja) {
        this.naziv = naziv;
        this.skraceniNaziv = skraceniNaziv;
        this.godinaAkreditacije = godinaAkreditacije;
        this.trajanje = trajanje;
        this.nazivZvanja = nazivZvanja;
        predmeti = new ArrayList<>();
        studIndexi = new ArrayList<>();
        vrsteStudija = new ArrayList<>();
    }

    public void addVrstaStudija(VrstaStudija vrstaStudija) {
        if (vrsteStudija == null) {
            vrsteStudija = new ArrayList<>();
        }
        vrsteStudija.add(vrstaStudija);
        vrstaStudija.setStudProgram(this);
    }

    public void addStudIndex(StudIndex studIndex) {
        if (studIndexi == null) {
            studIndexi = new ArrayList<>();
        }
        studIndexi.add(studIndex);
        studIndex.setStudProgram(this);
    }

    public void addPredmet(Predmet predmet) {
        if (predmeti == null) {
            predmeti = new ArrayList<>();
        }
        predmeti.add(predmet);
        predmet.setStudProgram(this);
    }

    public List<StudIndex> getStudIndexi() {
        return studIndexi;
    }

    public int getIdstudProgram() {
        return this.idstudProgram;
    }

    public String getNaziv() {
        return this.naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSkraceniNaziv() {
        return this.skraceniNaziv;
    }

    public void setSkraceniNaziv(String skraceniNaziv) {
        this.skraceniNaziv = skraceniNaziv;
    }

    public LocalDate getGodinaAkreditacije() {
        return godinaAkreditacije;
    }

    public void setGodinaAkreditacije(LocalDate godinaAkreditacije) {
        this.godinaAkreditacije = godinaAkreditacije;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public String getNazivZvanja() {
        return nazivZvanja;
    }

    public void setNazivZvanja(String nazivZvanja) {
        this.nazivZvanja = nazivZvanja;
    }

    public List<VrstaStudija> getVrsteStudija() {
        return vrsteStudija;
    }


    /*public Student removeStudent(Student student) {
        getStudents().remove(student);
        student.setStudProgram(null);

        return student;
    }*/

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmets) {
        this.predmeti = predmets;
    }

    @Override
    public String toString() {
        return "StudProgram{" +
                "idstudProgram=" + idstudProgram +
                ", naziv='" + naziv + '\'' +
                ", skraceniNaziv='" + skraceniNaziv + '\'' +
                ", godinaAkreditacije=" + godinaAkreditacije +
                ", trajanje=" + trajanje +
                ", nazivZvanja='" + nazivZvanja + '\'' +
                '}';
    }
}