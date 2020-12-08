package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.PolozioPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.repositories.PolozioPredmetRepository;
import studsluzba.repositories.PredmetRepository;

import java.util.List;

@Service
public class PolozioPredmetService {

    @Autowired
    PolozioPredmetRepository polozioPredmetRepository;

    @Autowired
    PredmetRepository predmetRepository;

    public void addPolozioPredmet(StudIndex aktivanIndex, Predmet predmet) {
        PolozioPredmet polozioPredmet = new PolozioPredmet();
        polozioPredmet.setStudentIndex(aktivanIndex);
        polozioPredmet.setUkupanBrojPoena(0);//todo
        polozioPredmet.setPriznatSaDrugogFaksa(false);//todo
        polozioPredmet.setIzlazakNaIspit(null);//todo
        polozioPredmet.setOcena(0);//todo
        polozioPredmetRepository.save(polozioPredmet);

        predmet.setPolozioPredmet(polozioPredmet);
        predmetRepository.save(predmet);

    }

    public List<PolozioPredmet> getPolozeniPredmetiByIndex(int broj){
        return polozioPredmetRepository.getPolozeniPredmetiByIndex(broj);
    }
}
