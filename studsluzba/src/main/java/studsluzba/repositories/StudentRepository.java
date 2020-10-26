package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.*;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("select s from Student s where lower(s.ime) like :ime or lower(s.prezime) like :prezime")
    List<Student> findStudentByNameAndSurname(String ime, String prezime);

    @Query("select s from Student s where s.idStudent = (select k.student.idStudent from StudIndex k where k.broj = :br)")
    Student selectStudentByIndex(int br);

    @Query("select p from PolozioPredmet p where p.idPolozioPredmet = (select k.student.idStudent from StudIndex k where k.broj = :br)")
    List<PolozioPredmet> selectPolozeniPredByIndex(int br);

    @Query("select s from Student s inner join s.srednjaSkola as sr where lower(sr.naziv) like :ime_srednje_skole")
    List<Student> findStudentByHighSchool(String ime_srednje_skole);

    @Query("select u from UpisGodina u inner join u.studentIndex as si where si.broj = :br")
    List<UpisGodina> findUpisaneGodineByIndex(int br);

    @Query("select o from ObnovaGodina o inner join o.studentIndeks as si where si.broj = :br")
    List<ObnovaGodina> findObnovljeneGodineByIndex(int br);

}
