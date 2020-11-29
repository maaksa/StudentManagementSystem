package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "studProgram")
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