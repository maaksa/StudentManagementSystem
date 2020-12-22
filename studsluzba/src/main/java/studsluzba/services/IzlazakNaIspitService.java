package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Ispit;
import studsluzba.model.IzlazakNaIspit;
import studsluzba.model.PolozioPredmet;
import studsluzba.model.PrijavaIspita;
import studsluzba.repositories.IzlazakNaIspitRepository;
import studsluzba.repositories.PolozioPredmetRepository;
import studsluzba.repositories.PrijavaIspitaRepository;

@Service
public class IzlazakNaIspitService {

    @Autowired
    IzlazakNaIspitRepository izlazakNaIspitRepository;

    @Autowired
    PolozioPredmetRepository polozioPredmetRepository;

    @Autowired
    PrijavaIspitaRepository prijavaIspitaRepository;

    public IzlazakNaIspit createIzlazak(Ispit ispit, PrijavaIspita prijavaIspita, PolozioPredmet polozioPredmet, double poeni){
        IzlazakNaIspit izlazakNaIspit = new IzlazakNaIspit();
        izlazakNaIspit.setPrijavljenIspit(prijavaIspita);
        izlazakNaIspit.setIspit(ispit);
        izlazakNaIspit.setPolozioPredmet(polozioPredmet);
        izlazakNaIspit.setBrojOsvojenihPoena(poeni);
        izlazakNaIspit.setIzasaoNaIspit(true);

        IzlazakNaIspit toReturn = izlazakNaIspitRepository.save(izlazakNaIspit);

        if(polozioPredmet != null) {
            polozioPredmet.setIzlazakNaIspit(izlazakNaIspit);
            polozioPredmetRepository.save(polozioPredmet);
        }
        prijavaIspita.setIzlazakNaIspit(izlazakNaIspit);
        prijavaIspitaRepository.save(prijavaIspita);

        return toReturn;
    }
}
