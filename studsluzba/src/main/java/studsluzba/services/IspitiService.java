package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.*;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IspitiService {

    @Autowired
    IspitRepository ispitRepository;

    @Autowired
    IspitniRokRepository ispitniRokRepository;

    public List<Ispit> getIspiti() {
        Iterable<Ispit> iter = ispitRepository.findAll();
        List<Ispit> rez = new ArrayList<Ispit>();
        iter.forEach(rez::add);
        return rez;
    }

    public List<StudIndex> getPrijavljeniStud(String sifraIspita) {
        return ispitRepository.findStudentsRegisteredForExam(sifraIspita);
    }

    public List<OsvojeniPredispitniPoeni> getRezIspit(String sifraIspita) {
        return ispitRepository.sortStudByExamResults(sifraIspita);
    }

    public void saveIspitniRok(LocalDate pocetak, LocalDate zavrsetak, SkolskaGodina skolskaGodina) {
        IspitniRok ispitniRok = new IspitniRok();
        ispitniRok.setDatumPocetka(pocetak.toString());
        ispitniRok.setDatumZavrsetka(zavrsetak.toString());
        ispitniRok.setSkolskaGod(skolskaGodina);

        ispitniRokRepository.save(ispitniRok);
    }

    public void saveIspit(String sifra, LocalDate datum, String vreme, IspitniRok ispitniRok, Predmet predmet, Nastavnik nastavnik) {
        Ispit ispit = new Ispit();
        ispit.setVremePocetka(vreme);
        ispit.setSifraIspita(sifra);
        ispit.setDatumOdrzavanja(datum);
        ispit.setPredmet(predmet);
        ispit.setIspitniRok(ispitniRok);
        ispit.setNastavnik(nastavnik);
        ispit.setUnetiPoeni(false);

        ispitRepository.save(ispit);
    }
}
