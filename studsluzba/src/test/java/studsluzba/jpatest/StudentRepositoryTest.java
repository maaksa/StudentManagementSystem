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
        Predmet predmet = new Predmet();
        VrstaStudija vrstaStudija = new VrstaStudija();

        //vrsta studija
        vrstaStudija.setPunNaziv("Osnovne akademske studije");
        vrstaStudija.setSkraceniNaziv("OAS");

        //predmet
        predmet.setBrojESPB(6);
        predmet.setBrojSemestra(5);
        predmet.setFondPredavanja(40);
        predmet.setFondVezbi(40);
        predmet.setOpis("Najjaci predmet");
        predmet.setNazivPredmeta("Softverske komponente");
        predmet.setSifraPredmeta("sk1");

        //studProg
        studProgram.addVrstaStudija(vrstaStudija);
        studProgram.addPredmet(predmet);
        studProgram.setGodinaAkreditacije(LocalDate.now());
        studProgram.setNaziv("Racunarske nauke");
        studProgram.setSkraceniNaziv("RN");
        studProgram.setNazivZvanja("Diplomirani informaticar");
        studProgram.setTrajanje(8);

        //polozioPred
        polozioPredmet.setOcena(10);
        polozioPredmet.addPredmet(predmet);

        //index
        studIndex.setGodina(2018);
        studIndex.setAktivan(true);
        studIndex.setBroj(57);
        studIndex.setOdKadJeAktivan(LocalDate.now());
        //studIndex.setProgram(null);
        studIndex.addPolozioPredmet(polozioPredmet);

        //srednja sk
        srednjaSkola.setMesto("Obrenovac");
        srednjaSkola.setNaziv("Gimnazija u Obrenovcu");
        srednjaSkola.setVrsta("Gimnazija");

        //student
        s.setIme("Nikola");
        s.setPrezime("Paunovic");
        s.setSrednjeIme("Paun");
        s.setBrojLicneKarte("3242525235");
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
        s.setPrivemail("np@gmail.com");
        s.setStudemail("np@raf.rs");
        s.setSrednjaSkola(srednjaSkola);
        s.setUpisaoPrvuGodinu(false);
        s.setVisokaSkola(null);
        s.addIndex(studIndex);
        s.setUlica("Petra Petrica");

        studRepo.save(s);

        /*//upit izvlacenje studenta preko broja indeksa
        Student student = studRepo.selectStudentByIndex(15);
        System.out.println(student);*/

        //upit selekcija svih položenih ispita preko broja indeksa studenta
        List<PolozioPredmet> polozioPredmeti = studRepo.selectPolozeniPredByIndex(57);
        System.out.println(polozioPredmeti);

       // List<Predmet> predmeti = studRepo.selectPredmetiByStudProg("RN");
      //  System.out.println(predmet);

    }
}

