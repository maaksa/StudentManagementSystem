package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.*;
import studsluzba.repositories.NastavnikRepository;
import studsluzba.repositories.StudIndexRepository;
import studsluzba.repositories.StudentRepository;
import studsluzba.repositories.ZvanjeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NastavnikService {

    @Autowired
    NastavnikRepository nastavnikRepository;

    @Autowired
    ZvanjeRepository zvanjeRepository;

//    public Optional<Student> changeIndex(Student s, Integer novaGodina, String novSmer, Integer novBroj, StudIndex studeIndexSelected) {
//        StudIndex novIndex = new StudIndex();
//
//        StudProgram studProgram = null;
//
//        List<StudProgram> programi = studProgramService.loadAll();
//        for (StudProgram sp : programi) {
//            if (sp.getSkraceniNaziv().equals(novSmer)) {
//                studProgram = sp;
//            }
//        }
//        studeIndexSelected.setAktivan(false);
//        studIndexRepository.save(studeIndexSelected);
//
//        novIndex.setStudProgram(studProgram);
//        novIndex.setAktivan(true);
//        novIndex.setStudent(s);
//        novIndex.setOdKadJeAktivan(LocalDate.now());
//        novIndex.setBroj(novBroj);
//        novIndex.setGodina(novaGodina);
//        studIndexRepository.save(novIndex);
//
//        return studentRepository.findById(s.getIdStudent());
//    }

    public List<Nastavnik> getNastavnici() {
        Iterable<Nastavnik> iter = nastavnikRepository.findAll();
        List<Nastavnik> rez = new ArrayList<Nastavnik>();
        iter.forEach(rez::add);
        return rez;
    }

    public void addZvanje(String nastavnikNazivZvanja, String nastavnikUzaNaucObla, LocalDate nastavnikDatumIzbora, Nastavnik nastavnik) {
        Zvanje zvanje = new Zvanje();
        zvanje.setUzaNaucnaOblast(nastavnikUzaNaucObla);
        zvanje.setDatumIzbora(nastavnikDatumIzbora);
        zvanje.setNazivZvanja(nastavnikNazivZvanja);

        zvanje.setNastavnik(nastavnik);

        zvanjeRepository.save(zvanje);

    }

}
