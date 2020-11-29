package studsluzba.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStudent;

    private String ime;
    private String prezime;
    private String srednjeIme;
    private long jmbg;
    private LocalDate daumRodjenja;
    private String mestoRodjenja;
    private String drzavljanstvo;
    private String nacionalnost;
    private char pol;
    private String mesto;
    private String ulica;
    private int brojUlice;
    private long brojTelefona;
    private String privemail;
    private String studemail;
    private String brojLicneKarte;
    private String licnuKartuIzdao;
    private boolean upisaoPrvuGodinu;
    private double uspehSrednjaSkola;
    private double uspehPrijemni;
    private String prelaz;


    @ManyToOne()
    @JoinColumn(name = "idSrednjaSkola")
    private SrednjaSkola srednjaSkola;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idVisokaSkola")
    private VisokaSkola visokaSkola;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<StudIndex> indexi;

    public Student() {

    }

    public Student(String ime, String prezime, String srednjeIme, long jmbg, LocalDate daumRodjenja, String mestoRodjenja, String drzavljanstvo, String nacionalnost, char pol, String mesto, String ulica, int brojUlice, long brojTelefona, String privemail, String studemail, String brojLicneKarte, String licnuKartuIzdao, boolean upisaoPrvuGodinu, double uspehSrednjaSkola, double uspehPrijemni, String prelaz/*, SrednjaSkola srednjaSkola*/, VisokaSkola visokaSkola) {
        this.ime = ime;
        this.prezime = prezime;
        this.srednjeIme = srednjeIme;
        this.jmbg = jmbg;
        this.daumRodjenja = daumRodjenja;
        this.mestoRodjenja = mestoRodjenja;
        this.drzavljanstvo = drzavljanstvo;
        this.nacionalnost = nacionalnost;
        this.pol = pol;
        this.mesto = mesto;
        this.ulica = ulica;
        this.brojUlice = brojUlice;
        this.brojTelefona = brojTelefona;
        this.privemail = privemail;
        this.studemail = studemail;
        this.brojLicneKarte = brojLicneKarte;
        this.licnuKartuIzdao = licnuKartuIzdao;
        this.upisaoPrvuGodinu = upisaoPrvuGodinu;
        this.uspehSrednjaSkola = uspehSrednjaSkola;
        this.uspehPrijemni = uspehPrijemni;
        this.prelaz = prelaz;
        //this.srednjaSkola = srednjaSkola;
        this.visokaSkola = visokaSkola;
        indexi = new ArrayList<>();
    }

    public void addIndex(StudIndex studIndex) {
        if (indexi == null) {
            indexi = new ArrayList<>();
        }
        indexi.add(studIndex);
        studIndex.setStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", srednjeIme='" + srednjeIme + '\'' +
                ", jmbg=" + jmbg +
                ", daumRodjenja=" + daumRodjenja +
                ", mestoRodjenja='" + mestoRodjenja + '\'' +
                ", drzavljanstvo='" + drzavljanstvo + '\'' +
                ", nacionalnost='" + nacionalnost + '\'' +
                ", pol=" + pol +
                ", mesto='" + mesto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", brojUlice=" + brojUlice +
                ", brojTelefona=" + brojTelefona +
                ", privemail='" + privemail + '\'' +
                ", studemail='" + studemail + '\'' +
                ", brojLicneKarte='" + brojLicneKarte + '\'' +
                ", licnuKartuIzdao='" + licnuKartuIzdao + '\'' +
                ", upisaoPrvuGodinu=" + upisaoPrvuGodinu +
                ", uspehSrednjaSkola=" + uspehSrednjaSkola +
                ", uspehPrijemni=" + uspehPrijemni +
                ", prelaz=" + prelaz +
                ", srednjaSkola=" + srednjaSkola +
                ", visokaSkola=" + visokaSkola +
                '}';
    }
}