package studsluzba.model;

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

	/*@OneToMany
	@JoinColumn(name = "idPredIspitne")
	private List<PredispitneObaveze> obaveze;*/

	
	/*@ManyToOne
	@JoinColumn(name = "idstudProgram")
	private StudProgram studProgram;*/

    public Predmet() {
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

	/*public List<PredispitneObaveze> getObaveze() {
		return obaveze;
	}

	public void setObaveze(List<PredispitneObaveze> obaveze) {
		this.obaveze = obaveze;
	}*/

    @Override
    public String toString() {
        return "Predmet{" +
                "sifraPredmeta='" + sifraPredmeta + '\'' +
                ", nazivPredmeta='" + nazivPredmeta + '\'' +
                ", opis='" + opis + '\'' +
                ", brojESPB=" + brojESPB +
                ", fondPredavanja=" + fondPredavanja +
                ", fondVezbi=" + fondVezbi +
                ", brojSemestra=" + brojSemestra +
                '}';
    }
}
