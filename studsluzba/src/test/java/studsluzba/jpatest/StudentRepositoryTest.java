package studsluzba.jpatest;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.*;
import studsluzba.repositories.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studRepo;

    @Test
    public void saveStudentTest() throws Exception {
        SrednjaSkola srednjaSkola = new SrednjaSkola();
        Student s = new Student();
        StudIndex studIndex = new StudIndex();
        PolozioPredmet polozioPredmet = new PolozioPredmet();
        StudProgram studProgram = new StudProgram();

        //studProg

        //polozioPred
        polozioPredmet.setOcena(10);
        polozioPredmet.setPredmet(null);

        //index
        studIndex.setGodina(2018);
        studIndex.setAktivan(true);
        studIndex.setBroj(15);
        studIndex.setOdKadJeAktivan(LocalDate.now());
        //studIndex.setProgram(null);
        studIndex.addPolozioPredmet(polozioPredmet);

        //srednja sk
        srednjaSkola.setMesto("Beograd");
        srednjaSkola.setNaziv("3. Gimnazija");
        srednjaSkola.setVrsta("gimnazija");

        //student
        s.setIme("misa");
        s.setPrezime("misic");
        s.setSrednjeIme("Marko");
        s.setBrojLicneKarte("32425252");
        s.setBrojTelefona(060123433);
        s.setBrojUlice(50);
        s.setDaumRodjenja(LocalDate.now());
        s.setDrzavljanstvo("srpsko");
        s.setJmbg(12345678);
        s.setMesto("Beograd");
        s.setLicnuKartuIzdao("Izdavac");
        s.setMestoRodjenja("Beograd");
        s.setNacionalnost("Srbina");
        s.setPol('m');
        s.setPrelaz(false);
        s.setUspehSrednjaSKola(4.50);
        s.setPrivemail("mm@gmail.com");
        s.setStudemail("mm@raf.rs");
        s.setSrednjaSkola(srednjaSkola);
        s.setUpisaoPrvuGodinu(false);
        s.setVisokaSkola(null);
        s.addIndex(studIndex);

        studRepo.save(s);

        //upit izvlacenje studenta preko broja indeksa
        Student student = studRepo.selectStudentByIndex(15);
        System.out.println(student);

    }
}

