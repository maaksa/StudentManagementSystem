package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import studsluzba.model.IspitniRok;
import studsluzba.model.Predmet;
import studsluzba.model.PrijavaIspita;

import java.util.List;

public interface PrijavaIspitaRepository extends CrudRepository<PrijavaIspita, Integer> {

    // ovo treba da vrati listu svih prijava studenata za ispit prosledjenog predmeta i roka i da su izasli na ispit
    @Query("select p from PrijavaIspita p where p.ispit.idIspit = (select i.idIspit from Ispit i where i.predmet" +
            "= :predmet and i.ispitniRok = :ispitniRok) and p.izlazakNaIspit.izasaoNaIspit is not null")
    List<PrijavaIspita> prijave (Predmet predmet, IspitniRok ispitniRok);

}
