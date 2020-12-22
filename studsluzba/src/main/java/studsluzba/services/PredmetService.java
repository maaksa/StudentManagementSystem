package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Predmet;
import studsluzba.repositories.PredmetRepository;

@Service
public class PredmetService {

    @Autowired
    PredmetRepository predmetRepository;

    public Predmet getPredmet(String naziv){
        Predmet predmet = predmetRepository.getPredmetByNazivPredmeta(naziv);

        if(predmet == null){
            predmet = new Predmet();
            predmet.setSifraPredmeta("78924");
            predmet.setNazivPredmeta(naziv);
            predmet.setOpis("Objektno orjentisani koncepti");
            predmet.setBrojESPB(8);
            predmet.setFondPredavanja(30);
            predmet.setFondVezbi(40);
            predmet.setBrojSemestra(2);
        }

        System.out.println(predmet);

        return predmetRepository.save(predmet);
    }

}
