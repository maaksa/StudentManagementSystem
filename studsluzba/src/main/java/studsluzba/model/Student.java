package studsluzba.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the student database table.
 */
@Entity
@Table(name = "student")
//@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
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
    private boolean prelaz;

    /*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idSrednjaSkola")
    private SrednjaSkola srednjaSkola;*/

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idSrednjaSkola")
    private SrednjaSkola srednjaSkola;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVisokaSkola")
    private VisokaSkola visokaSkola;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<StudIndex> indexi;

   /* @OneToMany(mappedBy = "index")
    private List<SlusaPredmet> slusaPredmet;*/

    public Student() {

    }

    public Student(String ime, String prezime, String srednjeIme, long jmbg, LocalDate daumRodjenja, String mestoRodjenja, String drzavljanstvo, String nacionalnost, char pol, String mesto, String ulica, int brojUlice, long brojTelefona, String privemail, String studemail, String brojLicneKarte, String licnuKartuIzdao, boolean upisaoPrvuGodinu, double uspehSrednjaSkola, double uspehPrijemni, boolean prelaz) {
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
    }

    public void addIndex(StudIndex studIndex) {
        if (indexi == null) {
            indexi = new ArrayList<>();
        }
        indexi.add(studIndex);
        studIndex.setStudent(this);
    }

    public int getIdstudent() {
        return this.idStudent;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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
                ", Privemail='" + privemail + '\'' +
                ", Studemail='" + studemail + '\'' +
                ", brojLicneKarte='" + brojLicneKarte + '\'' +
                ", licnuKartuIzdao='" + licnuKartuIzdao + '\'' +
                ", upisaoPrvuGodinu=" + upisaoPrvuGodinu +
                ", uspehSrednjaSkola=" + uspehSrednjaSkola +
                ", uspehPrijemni=" + uspehPrijemni +
                ", prelaz=" + prelaz +
                '}';
    }

    public String getSrednjeIme() {
        return srednjeIme;
    }

    public void setSrednjeIme(String srednjeIme) {
        this.srednjeIme = srednjeIme;
    }

    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    public LocalDate getDaumRodjenja() {
        return daumRodjenja;
    }

    public void setDaumRodjenja(LocalDate daumRodjenja) {
        this.daumRodjenja = daumRodjenja;
    }

    public String getMestoRodjenja() {
        return mestoRodjenja;
    }

    public void setMestoRodjenja(String mestoRodjenja) {
        this.mestoRodjenja = mestoRodjenja;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getBrojUlice() {
        return brojUlice;
    }

    public void setBrojUlice(int brojUlice) {
        this.brojUlice = brojUlice;
    }

    public long getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(long brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getPrivemail() {
        return privemail;
    }

    public void setPrivemail(String privemail) {
        privemail = privemail;
    }

    public String getStudemail() {
        return studemail;
    }

    public void setStudemail(String studemail) {
        studemail = studemail;
    }

    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public String getLicnuKartuIzdao() {
        return licnuKartuIzdao;
    }

    public void setLicnuKartuIzdao(String licnuKartuIzdao) {
        this.licnuKartuIzdao = licnuKartuIzdao;
    }

    public List<StudIndex> getIndexi() {
        return indexi;
    }

    public void setIndexi(List<StudIndex> indexi) {
        this.indexi = indexi;
    }

    public boolean isUpisaoPrvuGodinu() {
        return upisaoPrvuGodinu;
    }

    public void setUpisaoPrvuGodinu(boolean upisaoPrvuGodinu) {
        this.upisaoPrvuGodinu = upisaoPrvuGodinu;
    }

    public double getUspehSrednjaSKola() {
        return uspehSrednjaSkola;
    }

    public void setUspehSrednjaSKola(double uspehSrednjaSKola) {
        this.uspehSrednjaSkola = uspehSrednjaSKola;
    }

    public double getUspehPrijemni() {
        return uspehPrijemni;
    }

    public void setUspehPrijemni(double uspehPrijemni) {
        this.uspehPrijemni = uspehPrijemni;
    }

    public boolean isPrelaz() {
        return prelaz;
    }

    public void setPrelaz(boolean prelaz) {
        this.prelaz = prelaz;
    }


    public VisokaSkola getVisokaSkola() {
        return visokaSkola;
    }

    public void setVisokaSkola(VisokaSkola visokaSkola) {
        visokaSkola = visokaSkola;
    }


    public SrednjaSkola getSrednjaSkola() {
        return srednjaSkola;
    }

    public void setSrednjaSkola(SrednjaSkola srednjaSkola) {
        this.srednjaSkola = srednjaSkola;
    }


}