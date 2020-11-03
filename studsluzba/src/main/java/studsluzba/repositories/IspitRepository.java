package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.*;

import java.util.List;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {

    @Query("select s from StudIndex s inner join s.prijavaIspita as pi where pi.ispit.sifraIspita = :sifra")
    List<StudIndex> findStudentsRegisteredForExam(String sifra);

    //where pp.izlazakNaIspit.Ispit.sifra
    @Query("select avg(pp.ocena) from PolozioPredmet pp where pp.izlazakNaIspit.ispit.sifraIspita like :ispitSifra")
    Float getAverageGradeOnTheExam(String ispitSifra);

    @Query("select count(iz.izasaoNaIspit) from IzlazakNaIspit iz where iz.ispit.idIspit = (select i.idIspit " +
            "from Ispit i where i.predmet.nazivPredmeta like :nazivPredmeta " +
            "and i.predmet.polozioPredmet.studentIndex.idStudIndex = (select si.idStudIndex from StudIndex si where si.broj = :broj))")
    Integer getCountIspitOut(String nazivPredmeta, int broj);

    //selekcija ostvarenih poena na predispinim obavezama za studenta na određenom
    //predmetu u školskoj godini
    @Query("select p from PredispitneObaveze p where p.predmet.idPredmet = (select pre.predmet.idPredmet from" +
            " DrziPredmet pre where pre.predmet.nazivPredmeta like :naziv and" +
            " pre.skolskaGod.datum = :godina and pre.idDrziPredmet = (select sl.drziPredmet.idDrziPredmet from SlusaPredmet sl where " +
            "sl.index.broj = :broj))")
    List<PredispitneObaveze> getPoint(int broj, String naziv, int godina);

//    @Query("select si.broj, si.godina, si.studProgram.skraceniNaziv, si.prijavaIspita.izlazakNaIspit.brojOsvojenihPoena from StudIndex si where si.prijavaIspita.ispit.idIspit = :id")
//    List<Object[]> sortStudByExamResults(int id);
//si.broj, si.godina, si.studProgram.skraceniNaziv,
    @Query("select si.predIspitne from StudIndex si where si.idStudIndex in (select pp.studentIndex.idStudIndex from PolozioPredmet pp where pp.izlazakNaIspit.ispit.sifraIspita like :sifraIspita) " +
            "order by si.studProgram.skraceniNaziv asc, si.godina asc, si.broj")
    List<OsvojeniPredispitniPoeni> sortStudByExamResults(String sifraIspita);


}



