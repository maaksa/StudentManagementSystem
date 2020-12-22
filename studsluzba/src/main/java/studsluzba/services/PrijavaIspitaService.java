package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Ispit;
import studsluzba.model.PrijavaIspita;
import studsluzba.model.StudIndex;
import studsluzba.repositories.PrijavaIspitaRepository;

import java.time.LocalDate;

@Service
public class PrijavaIspitaService {

    @Autowired
    PrijavaIspitaRepository prijavaIspitaRepository;

    public PrijavaIspita createPrijava(Ispit ispit, StudIndex si){
        PrijavaIspita prijavaIspita = new PrijavaIspita();
        prijavaIspita.setIspit(ispit);
        prijavaIspita.setStudIndexi(si);
        prijavaIspita.setDatum(LocalDate.now());

        return prijavaIspitaRepository.save(prijavaIspita);
    }

}
