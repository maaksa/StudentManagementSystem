package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;
import studsluzba.model.PredispitneObaveze;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.StudIndex;

import java.util.List;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {

    @Query("select s from StudIndex s inner join s.prijavaIspita as pi where pi.ispit.idIspit = :idIspit")
    List<StudIndex> findStudentsRegisteredForExam(int idIspit);


    @Query("select avg(pp.ocena) from PolozioPredmet pp where pp.studentIndex.prijavaIspita.ispit.sifraIspita like :ispitSifra")
    Float getAverageGradeOnTheExam(String ispitSifra);

    @Query("select count(iz.izasaoNaIspit) from IzlazakNaIspit iz where iz.ispit.idIspit = (select i.idIspit " +
            "from Ispit i where i.predmet.nazivPredmeta like :nazivPredmeta " +
            "and i.idIspit = (select si.prijavaIspita.ispit.idIspit from StudIndex si where si.broj = :broj))")
    Integer getCountIspitOut(String nazivPredmeta, int broj);

    //selekcija ostvarenih poena na predispinim obavezama za studenta na određenom
    //predmetu u školskoj godini
    @Query("select p from PredispitneObaveze p where p.predmet.idPredmet = (select pre.predmet.idPredmet from" +
            " DrziPredmet pre where pre.predmet.nazivPredmeta like :naziv and" +
            " pre.skolskaGod.datum = :godina and pre.idDrziPredmet = (select sl.drziPredmet.idDrziPredmet from SlusaPredmet sl where " +
            "sl.index.broj = :broj))")
    List<PredispitneObaveze> getPoint(int broj, String naziv, int godina);

    //List<StudIndex> sortStudByExamResults(String sifraIspita);
}
