package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.*;
import studsluzba.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class DosijeService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudProgramRepository studProgramRepository;

    @Autowired
    UpisGodineRepository upisGodineRepository;

    @Autowired
    PredmetRepository predmetRepository;

    @Autowired
    ObnovaGodinaRepository obnovaGodinaRepository;

    @Autowired
    SkolskaGodinaRepository skolskaGodinaRepository;

    public List<PolozioPredmet> getPolozeni(String smer, int studIndex, int godina) {
        return studentRepository.selectPolozeniPredByIndex(smer, studIndex, godina);
    }

    public List<SlusaPredmet> getSlusa(String smer, int studIndex, int godina) {
        return studentRepository.selectSlusaPredByIndex(smer, studIndex, godina);
    }

    public List<UpisGodina> getUpisGodina(String smer, int studIndex, int godina) {
        return studentRepository.findUpisaneGodineByIndex(smer, studIndex, godina);
    }

    public List<ObnovaGodina> getObnovaGodina(String smer, int studIndex, int godina) {
        return studentRepository.findObnovljeneGodineByIndex(smer, studIndex, godina);
    }

    public List<Student> getStudenti() {
        Iterable<Student> iter = studentRepository.findAll();
        List<Student> rez = new ArrayList<Student>();
        iter.forEach(rez::add);
        return rez;
    }

    public List<Predmet> getPredmetiZaStudProgram(String smer) {
        Iterable<Predmet> iter = studProgramRepository.selectPredmetiByStudProg(smer);
        List<Predmet> rez = new ArrayList<Predmet>();
        iter.forEach(rez::add);
        return rez;
    }

    public void savaUpis(List<Predmet> predmetiSelected, SkolskaGodina godinaUpisa, StudIndex studIndex) {
        UpisGodina upisGodinaToSave = new UpisGodina();
        upisGodinaToSave.setStudentIndex(studIndex);
        upisGodinaToSave.setNapomena(null);
        upisGodinaToSave.setDatum(godinaUpisa.getDatum());
        upisGodinaToSave.setSkolskaGodina(godinaUpisa);

        godinaUpisa.setUpisGodine(upisGodinaToSave);
        skolskaGodinaRepository.save(godinaUpisa);

        upisGodineRepository.save(upisGodinaToSave);

        for (Predmet p : predmetiSelected) {
            p.setUpisGodina(upisGodinaToSave);
            predmetRepository.save(p);
        }

    }

    public void saveObnova(List<Predmet> predmetiSelected, SkolskaGodina godinaUpisa, StudIndex studIndex) {
        ObnovaGodina obnovaGodinaToSave = new ObnovaGodina();
        obnovaGodinaToSave.setStudentIndeks(studIndex);
        obnovaGodinaToSave.setNapomena(null);
        obnovaGodinaToSave.setDatum(godinaUpisa.getDatum());
        obnovaGodinaToSave.setSkolskaGodina(godinaUpisa);

        godinaUpisa.setObnovaGodine(obnovaGodinaToSave);
        skolskaGodinaRepository.save(godinaUpisa);

        obnovaGodinaRepository.save(obnovaGodinaToSave);

        for (Predmet p : predmetiSelected) {
            p.setObnova(obnovaGodinaToSave);
            predmetRepository.save(p);
        }
//        List<SkolskaGodina> skolskaGodine = this.getSkolskeGodine();
//        SkolskaGodina skolskaGodinaToSave = new SkolskaGodina();
//        ObnovaGodina obnovaGodinaToSave = new ObnovaGodina();
//        obnovaGodinaToSave.setStudentIndeks(studIndex);
//        obnovaGodinaToSave.setDatum(godinaUpisa);
//
//        for (SkolskaGodina sk : skolskaGodine) {
//            if (sk.getDatum() == godinaUpisa) {
//                obnovaGodinaToSave.setSkolskaGodina(sk);
//                break;
//            } else {
//                skolskaGodinaToSave.setDatum(godinaUpisa);
//                skolskaGodinaToSave.setAktivna(true);
//                skolskaGodinaToSave.setObnovaGodine(obnovaGodinaToSave);
//                skolskaGodinaRepository.save(skolskaGodinaToSave);
//                obnovaGodinaToSave.setSkolskaGodina(skolskaGodinaToSave);
//            }
//        }
//
//        //todo napomenu u gui-ju TEXTAREA
//        obnovaGodinaToSave.setNapomena(null);
//
//        obnovaGodinaRepository.save(obnovaGodinaToSave);
//
//        for (Predmet p : predmetiSelected) {
//            p.setObnova(obnovaGodinaToSave);
//            predmetRepository.save(p);
//        }
    }

    public List<SkolskaGodina> getSkolskeGodine() {
        Iterable<SkolskaGodina> iter = skolskaGodinaRepository.findAll();
        List<SkolskaGodina> rez = new ArrayList<SkolskaGodina>();
        iter.forEach(rez::add);
        return rez;
    }

    public Student saveStudent(Student ss) {
        return studentRepository.save(ss);
    }
}
