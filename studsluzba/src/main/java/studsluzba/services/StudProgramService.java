package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.StudProgram;
import studsluzba.repositories.StudProgramRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudProgramService {

    @Autowired
    StudProgramRepository studProgramRepo;

    public StudProgram saveStudProgram(String punNaziv, String skraceniNaziv) {
        StudProgram sp = new StudProgram();
        sp.setNaziv(punNaziv);
        sp.setSkraceniNaziv(skraceniNaziv);
        return studProgramRepo.save(sp);
    }

    public List<StudProgram> loadAll() {
        //findAll metoda nam vraca Iterable po specifikaciji
        //nama treba da vratimo List<>, iterable ima metodu forEach koja ce da iz iterable prepakuje u listu
        Iterable<StudProgram> iter = studProgramRepo.findAll();
        List<StudProgram> rez = new ArrayList<StudProgram>();
        iter.forEach(rez::add);
        return rez;
    }


}
