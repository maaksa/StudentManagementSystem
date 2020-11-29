package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.*;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    //upit selekcija studenta koristeci ime ili prezime ili ime i prezime
    @Query("select s from Student s where "
            + "(:ime is null or lower(s.ime) like :ime) and "
            + "(:prezime is null or lower(s.prezime) like :prezime)")
    List<Student> findStudentByNameAndSurname(String ime, String prezime);

    //upit izvlacenje studenta preko broja indeksa
    @Query("select s from Student s where s.idStudent = (select k.student.idStudent from StudIndex k where k.broj = :br and k.studProgram.skraceniNaziv like :smer and k.godina = :godina)")
    Student selectStudentByIndex(String smer, int br, int godina);

    //upit selekcija svih položenih ispita preko broja indeksa studenta
    @Query("select p from PolozioPredmet p where p.studentIndex.broj = :br")
    List<PolozioPredmet> selectPolozeniPredByIndex(int br);

    //upit selekcija studenata koji su zavrsili odredjenu srednju skolu
    @Query("select s from Student s where lower(s.srednjaSkola.naziv) like :ime_srednje_skole")
    List<Student> findStudentByHighSchool(String ime_srednje_skole);

    //pregled svih upisanih godina za broj indeksa
    @Query("select u from UpisGodina u where u.studentIndex.broj = :br")
    List<UpisGodina> findUpisaneGodineByIndex(int br);

    //pregled obnovljenih godina za broj indeksa
    @Query("select o from ObnovaGodina o where o.studentIndeks.broj = :br")
    List<ObnovaGodina> findObnovljeneGodineByIndex(int br);

}
