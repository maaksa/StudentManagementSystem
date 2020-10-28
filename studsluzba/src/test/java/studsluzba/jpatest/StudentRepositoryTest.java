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
        SkolskaGodina skolskaGodina = new SkolskaGodina();
        ObnovaGodina obnovaGodina = new ObnovaGodina();
        UpisGodina upisGodina = new UpisGodina();
        Ispit ispit = new Ispit();
        PrijavaIspita prijavaIspita = new PrijavaIspita();
        Zvanje zvanje = new Zvanje();
        Nastavnik nastavnik = new Nastavnik();

        //nastavnil
        nastavnik.addZvanje(zvanje);
        nastavnik.setIme("Petar");
        nastavnik.setPrezime("Petric");
        nastavnik.setEmail("pp@raf.rs");
        nastavnik.setObrazovanje("treci stepen");
        nastavnik.setSrednjeIme("Pera");

        //zvanje
        zvanje.setDatumIzbora(LocalDate.now());
        zvanje.setNazivZvanja("Dipl inzinjer");
        zvanje.setUzaNaucnaOblast("truc truc...");

        //ispit
        ispit.setDatumOdrzavanja(LocalDate.now());
        ispit.setUnetiPoeni(false);
        ispit.setVremePocetka("12:00");
        ispit.setPredmet(predmet);
        ispit.setNastavnik(nastavnik);
        ispit.addPrijavaIspita(prijavaIspita);

        //prijavaIpsita
        prijavaIspita.addStudIndex(studIndex);
        prijavaIspita.setDatum(LocalDate.now());

        //Upis godine
        upisGodina.setDatum(2020);
        upisGodina.setSkolskaGodina(skolskaGodina);
        upisGodina.setNapomena("napomena");

        //Obnova godine
        obnovaGodina.setDatum(2020);
        obnovaGodina.setNapomena("Napomena");
        obnovaGodina.setSkolskaGodina(skolskaGodina);

        //Skolska godina
        skolskaGodina.setDatum(2020);
        skolskaGodina.setAktivna(true);


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
        predmet.setIspit(ispit);

        //studProg
        studProgram.addVrstaStudija(vrstaStudija);
        studProgram.addPredmet(predmet);
        studProgram.setGodinaAkreditacije(LocalDate.now());
        studProgram.setNaziv("Racunarske nauke");
        studProgram.setSkraceniNaziv("RN");
        studProgram.setNazivZvanja("Diplomirani informaticar");
        studProgram.setTrajanje(8);

        //polozioPred
        polozioPredmet.setOcena(8);
        polozioPredmet.addPredmet(predmet);

        //index
        studIndex.setGodina(2018);
        studIndex.setAktivan(true);
        studIndex.setBroj(57);
        studIndex.setOdKadJeAktivan(LocalDate.now());
        //studIndex.setProgram(null);
        studIndex.addPolozioPredmet(polozioPredmet);
        studIndex.addUpisGodina(upisGodina);
        studIndex.addObnovaGodine(obnovaGodina);

        //srednja sk
        srednjaSkola.setMesto("Obrenovac");
        srednjaSkola.setNaziv("Gimnazija u Obrenovcu");
        srednjaSkola.setVrsta("Gimnazija");
        srednjaSkola.setStudent(s);
        //srednjaSkola.addStudent(s);

        //student
        s.setIme("Filip");
        s.setPrezime("Cmiljanovic");
        s.setSrednjeIme("Fica");
        s.setBrojLicneKarte("52156654433");
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
        s.setPrivemail("nn@gmail.com");
        s.setStudemail("nn@raf.rs");
        s.setUpisaoPrvuGodinu(false);
        s.setVisokaSkola(null);
        s.addIndex(studIndex);
        s.setUlica("Petra Petrica");
        s.setSrednjaSkola(srednjaSkola);



        studRepo.save(s);

        /*//upit izvlacenje studenta preko broja indeksa
        Student student = studRepo.selectStudentByIndex(15);
        System.out.println(student);*/

        //upit selekcija svih položenih ispita preko broja indeksa studenta
        /*List<PolozioPredmet> polozioPredmeti = studRepo.selectPolozeniPredByIndex(57);
        System.out.println(polozioPredmeti);*/

        //upit selekcija studenta koristeci ime ili prezime ili ime i prezime
        /*List<Student> studenti = studRepo.findStudentByNameAndSurname("nikola", null);
        System.out.println(studenti);*/

        //upit selekcija studenata koji su zavrsili odredjenu srednju skolu
        //List<Student> studenti = studRepo.findStudentByHighSchool("gimnazija u obrenovcu");
        //System.out.println(studenti);

        //pregled svih upisanih godina za broj indeksa
        // List<UpisGodina> upisaneGodine = studRepo.findUpisaneGodineByIndex(57);
        // System.out.println(upisaneGodine);

        //pregled obnovljenih godina za broj indeksa
        /* List<ObnovaGodina> obnovaGodine = studRepo.findObnovljeneGodineByIndex(57);
        System.out.println(obnovaGodine);*/

    }
}

