package studsluzba.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "zvanje")
public class Zvanje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZvanje;

    private LocalDate datumIzbora;
    private String uzaNaucnaOblast;
    private String nazivZvanja;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "idNastavnik")
    private Nastavnik nastavnik;

    public Zvanje() {
    }

    public Zvanje(LocalDate datumIzbora, String uzaNaucnaOblast, String nazivZvanja) {
        this.datumIzbora = datumIzbora;
        this.uzaNaucnaOblast = uzaNaucnaOblast;
        this.nazivZvanja = nazivZvanja;
    }

    public int getZvanjeid() {
        return idZvanje;
    }

    public LocalDate getDatumIzbora() {
        return datumIzbora;
    }

    public void setDatumIzbora(LocalDate datumIzbora) {
        this.datumIzbora = datumIzbora;
    }

    public String getUzaNaucnaOblast() {
        return uzaNaucnaOblast;
    }

    public void setUzaNaucnaOblast(String uzaNaucnaOblast) {
        this.uzaNaucnaOblast = uzaNaucnaOblast;
    }

    public String getNazivZvanja() {
        return nazivZvanja;
    }

    public void setNazivZvanja(String nazivZvanja) {
        this.nazivZvanja = nazivZvanja;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }
}
