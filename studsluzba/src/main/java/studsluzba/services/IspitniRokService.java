package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.Ispit;
import studsluzba.model.IspitniRok;
import studsluzba.model.SkolskaGodina;
import studsluzba.repositories.IspitRepository;
import studsluzba.repositories.IspitniRokRepository;

@Service
public class IspitniRokService {

    @Autowired
    IspitniRokRepository ispitniRokRepository;

    @Autowired
    IspitRepository ispitRepository;

    public IspitniRok createIspitniRok(SkolskaGodina skolskaGodina, String naziv, Ispit ispit) {

        IspitniRok ispitniRok = new IspitniRok();
        ispitniRok.setSkolskaGod(skolskaGodina);

        switch (naziv) {
            case "jun":
                ispitniRok.setDatumPocetka("jun");
                ispitniRok.setDatumZavrsetka("jul");
                break;
            case "jul":
                ispitniRok.setDatumPocetka("jul");
                ispitniRok.setDatumZavrsetka("avgust");
                break;
            case "avgust":
                ispitniRok.setDatumPocetka("avgust");
                ispitniRok.setDatumZavrsetka("septembar");
                break;
            case "septembar":
                ispitniRok.setDatumPocetka("septembar");
                ispitniRok.setDatumZavrsetka("oktobar");
                break;
        }

        IspitniRok toReturn = ispitniRokRepository.save(ispitniRok);

        ispit.setIspitniRok(ispitniRok);

        ispitRepository.save(ispit);

        return toReturn;

    }

}
