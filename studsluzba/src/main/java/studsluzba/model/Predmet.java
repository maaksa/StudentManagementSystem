package studsluzba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "predmet")
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPredmet;

    private String sifraPredmeta;
    private String nazivPredmeta;
    private String opis;
    private int brojESPB;
    private int fondPredavanja;
    private int fondVezbi;
    private int brojSemestra;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idPolozioPredmet")
    private PolozioPredmet polozioPredmet;

    //vise ispita
    @OneToMany(mappedBy = "predmet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Ispit> ispit;

    @OneToMany(mappedBy = "predmet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<PredispitneObaveze> obaveze;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idObnovaGodina")
    private ObnovaGodina obnova;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idstudProgram")
    private StudProgram studProgram;

    public Predmet() {
    }

    public Predmet(String sifraPredmeta, String nazivPredmeta, String opis, int brojESPB, int fondPredavanja, int fondVezbi, int brojSemestra, PolozioPredmet polozioPredmet,  ObnovaGodina obnovaGodina, StudProgram studProgram) {
        this.sifraPredmeta = sifraPredmeta;
        this.nazivPredmeta = nazivPredmeta;
        this.opis = opis;
        this.brojESPB = brojESPB;
        this.fondPredavanja = fondPredavanja;
        this.fondVezbi = fondVezbi;
        this.brojSemestra = brojSemestra;
        this.polozioPredmet = polozioPredmet;
        this.obnova = obnovaGodina;
        this.studProgram = studProgram;
        obaveze = new ArrayList<>();
    }

    public void addIspiti(Ispit ispiti) {
        if (ispit == null) {
            ispit = new ArrayList<>();
        }
        ispit.add(ispiti);
        ispiti.setPredmet(this);
    }

    public void addPredIspitne(PredispitneObaveze predObaveze) {
        if (obaveze == null) {
            obaveze = new ArrayList<>();
        }
        obaveze.add(predObaveze);
        predObaveze.setPredmet(this);
    }

    public void setObnova(ObnovaGodina obnova) {
        this.obnova = obnova;
    }

    public ObnovaGodina getObnova() {
        return obnova;
    }

    public void setPolozioPredmet(PolozioPredmet polozioPredmet) {
        this.polozioPredmet = polozioPredmet;
    }

    public PolozioPredmet getPolozioPredmet() {
        return polozioPredmet;
    }

    public int getId() {
        return idPredmet;
    }

    public String getSifraPredmeta() {
        return sifraPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(int brojESPB) {
        this.brojESPB = brojESPB;
    }

    public int getFondPredavanja() {
        return fondPredavanja;
    }

    public void setFondPredavanja(int fondPredavanja) {
        this.fondPredavanja = fondPredavanja;
    }

    public int getFondVezbi() {
        return fondVezbi;
    }

    public void setFondVezbi(int fondVezbi) {
        this.fondVezbi = fondVezbi;
    }

    public int getBrojSemestra() {
        return brojSemestra;
    }

    public void setBrojSemestra(int brojSemestra) {
        this.brojSemestra = brojSemestra;
    }

    public void setStudProgram(StudProgram studProgram) {
        this.studProgram = studProgram;
    }

    public StudProgram getStudProgram() {
        return studProgram;
    }

    public List<Ispit> getIspit() {
        return ispit;
    }

    public void setIspit(List<Ispit> ispit) {
        this.ispit = ispit;
    }

    public int getIdPredmet() {
        return idPredmet;
    }

    public List<PredispitneObaveze> getObaveze() {
        return obaveze;
    }

    public void setObaveze(List<PredispitneObaveze> obaveze) {
        this.obaveze = obaveze;
    }


    @Override
    public String toString() {
        return "Predmet{" +
                "nazivPredmeta='" + nazivPredmeta + '\'' +
                '}';
    }
}
