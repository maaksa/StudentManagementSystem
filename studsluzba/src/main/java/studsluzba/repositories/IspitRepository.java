package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Ispit;
import studsluzba.model.StudIndex;

import java.util.List;

public interface IspitRepository extends CrudRepository<Ispit, Integer> {

    @Query("select s from StudIndex s inner join s.prijavaIspita as pi where pi.ispit.idIspit = :idIspit")
    List<StudIndex> findStudentsRegisteredForExam(int idIspit);

    //@Query("select avg(pp.ocena) from PolozioPredmet pp inner join pp.predmeti as p where p.ispit.idIspit = :idIspit")
    /*@Query("select avg(pp.ocena) from PolozioPredmet pp where pp.studentIndex.prijavaIspita.idPrijava = (select p.polozioPredmet.idPolozioPredmet from Predmet p where p.ispit.idIspit = :idIspit)")
    Float getAverageGradeOnTheExam(int idIspit);*/


    @Query("select avg(pp.ocena) from PolozioPredmet pp where pp.studentIndex.prijavaIspita.ispit.predmet.nazivPredmeta like :ispitName")
    Float getAverageGradeOnTheExam(String ispitName);
}
