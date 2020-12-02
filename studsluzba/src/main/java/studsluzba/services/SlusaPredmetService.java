package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Predmet;
import studsluzba.model.SlusaPredmet;
import studsluzba.model.StudProgram;
import studsluzba.repositories.SlusaPredmetRepository;
import studsluzba.repositories.StudProgramRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlusaPredmetService {

    @Autowired
    StudProgramRepository studProgramRepo;

    @Autowired
    SlusaPredmetRepository slusaPredmetRepo;



//    public List<StudProgram> loadAll() {
//        Iterable<SlusaPredmet> iter = slusaPredmetRepo.getIndex();
//        List<StudProgram> rez = new ArrayList<StudProgram>();
//        iter.forEach(rez::add);
//        return rez;
//    }

    public List<Predmet> getPredmetiByProgram(String smer) {
        List<Predmet> predmetiToReturn = studProgramRepo.selectPredmetiByStudProg(smer);
        return predmetiToReturn;
    }

}
