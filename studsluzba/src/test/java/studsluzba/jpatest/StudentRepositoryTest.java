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
        IzlazakNaIspit izlazakNaIspit = new IzlazakNaIspit();
        PredispitneObaveze predispitneObaveze = new PredispitneObaveze();
        OsvojeniPredispitniPoeni osvojeniPredispitniPoeni = new OsvojeniPredispitniPoeni();
        SlusaPredmet slusaPredmet = new SlusaPredmet();
        DrziPredmet drziPredmet = new DrziPredmet();
        PredispitneObaveze predispitneObaveze1 = new PredispitneObaveze();



        // Slusa predmet
        slusaPredmet.setIndex(studIndex);


        //Drzi predmet
        drziPredmet.addSlusaPredmet(slusaPredmet);
        //drziPredmet.setNastavnik(nastavnik);
        drziPredmet.setPredmet(predmet);
        drziPredmet.setSkolskaGod(skolskaGodina);
        drziPredmet.setSifra("1234");

        //Osvojene pred
        osvojeniPredispitniPoeni.setUkupanBrojPoena(45);
        osvojeniPredispitniPoeni.setStudentIndeks(studIndex);
        osvojeniPredispitniPoeni.addPredIspitne(predispitneObaveze);


        //pred ispitne obaveze
        predispitneObaveze.setPoeni(45);
        predispitneObaveze.setMaxBrp(50);
        predispitneObaveze.setVrstaObabeza("Kolokvijum");
        predispitneObaveze.setSkolskaGodina(skolskaGodina);


        predispitneObaveze1.setPoeni(30);
        predispitneObaveze1.setMaxBrp(50);
        predispitneObaveze1.setVrstaObabeza("Kolokvijum");
        predispitneObaveze1.setSkolskaGodina(skolskaGodina);



        //nastavnil
        nastavnik.addZvanje(zvanje);
        nastavnik.setIme("Petar");
        nastavnik.setPrezime("Petric");
        nastavnik.setEmail("pp@raf.rs");
        nastavnik.setObrazovanje("treci stepen");
        nastavnik.setSrednjeIme("Pera");
        nastavnik.addDrziPredmet(drziPredmet);

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
        ispit.setSifraIspita("1234");

        //izlazak na Ispit

        izlazakNaIspit.setNapomena("Sta god");
        izlazakNaIspit.setIzasaoNaIspit(true);
        izlazakNaIspit.setPonistavanje(false);
        izlazakNaIspit.setBrojOsvojenihPoena(95);
        izlazakNaIspit.setIspit(ispit);
        izlazakNaIspit.setPrijavljenIspit(prijavaIspita);


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
        predmet.addPredIspitne(predispitneObaveze);
        predmet.addPredIspitne(predispitneObaveze1);


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
        studIndex.setBroj(45);
        studIndex.setOdKadJeAktivan(LocalDate.now());
        //studIndex.setProgram(null);
        studIndex.addPolozioPredmet(polozioPredmet);
        studIndex.addUpisGodina(upisGodina);
        studIndex.addObnovaGodine(obnovaGodina);
        studIndex.addOsvojeniPoeni(osvojeniPredispitniPoeni);

        //srednja sk
        srednjaSkola.setMesto("Obrenovac");
        srednjaSkola.setNaziv("Gimnazija u Obrenovcu");
        srednjaSkola.setVrsta("Gimnazija");
        srednjaSkola.setStudent(s);
        //srednjaSkola.addStudent(s);

        //student
        s.setIme("Milos");
        s.setPrezime("Maksimovic");
        s.setSrednjeIme("Maxa");
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



        //studRepo.save(s);

        //upit izvlacenje studenta preko broja indeksa
       // Student student = studRepo.selectStudentByIndex(45);
       //System.out.println(student);

        //upit selekcija svih položenih ispita preko broja indeksa studenta
       // List<PolozioPredmet> polozioPredmeti = studRepo.selectPolozeniPredByIndex(45);
        //System.out.println(polozioPredmeti);

        //upit selekcija studenta koristeci ime ili prezime ili ime i prezime
       // List<Student> studenti = studRepo.findStudentByNameAndSurname("milos", null);
       // System.out.println(studenti);

        //upit selekcija studenata koji su zavrsili odredjenu srednju skolu
        //List<Student> studenti = studRepo.findStudentByHighSchool("gimnazija u obrenovcu");
        //System.out.println(studenti);

        //pregled svih upisanih godina za broj indeksa
        // List<UpisGodina> upisaneGodine = studRepo.findUpisaneGodineByIndex(45);
         //System.out.println(upisaneGodine);

        //pregled obnovljenih godina za broj indeksa
        //List<ObnovaGodina> obnovaGodine = studRepo.findObnovljeneGodineByIndex(45);
       // System.out.println(obnovaGodine);

    }
}

