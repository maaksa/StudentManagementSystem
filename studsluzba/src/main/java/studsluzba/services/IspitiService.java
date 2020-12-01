package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Ispit;
import studsluzba.model.OsvojeniPredispitniPoeni;
import studsluzba.model.StudIndex;
import studsluzba.repositories.IspitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class IspitiService {

    @Autowired
    IspitRepository ispitRepository;

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

    public Ispit saveIspit(Ispit ss) {
        return ispitRepository.save(ss);
    }
}
