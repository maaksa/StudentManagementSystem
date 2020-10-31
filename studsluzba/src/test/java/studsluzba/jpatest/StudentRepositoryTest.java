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
        IspitniRok ispitniRok = new IspitniRok();
        PrijavaIspita prijavaIspita = new PrijavaIspita();
        Zvanje zvanje = new Zvanje();
        Nastavnik nastavnik = new Nastavnik();
        IzlazakNaIspit izlazakNaIspit = new IzlazakNaIspit();
        IzlazakNaIspit izlazakNaIspit1 = new IzlazakNaIspit();
        PredispitneObaveze predispitneObaveze = new PredispitneObaveze();
        OsvojeniPredispitniPoeni osvojeniPredispitniPoeni = new OsvojeniPredispitniPoeni();
        SlusaPredmet slusaPredmet = new SlusaPredmet();
        DrziPredmet drziPredmet = new DrziPredmet();
        PredispitneObaveze predispitneObaveze1 = new PredispitneObaveze();
        VisokaSkola visokaSkola = new VisokaSkola();

        // Slusa predmet
        slusaPredmet.setIndex(studIndex);
        slusaPredmet.setDrziPredmet(drziPredmet);//ovo

        //Drzi predmet
        drziPredmet.addSlusaPredmet(slusaPredmet);
        drziPredmet.setNastavnik(nastavnik);
        drziPredmet.setPredmet(predmet);
        drziPredmet.setSkolskaGod(skolskaGodina);
        drziPredmet.setSifra("1234");


        //Osvojene pred
        osvojeniPredispitniPoeni.setUkupanBrojPoena(60);
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
        ispit.setNastavnik(nastavnik);
        ispit.addPrijavaIspita(prijavaIspita);
        ispit.setSifraIspita("1234");
        ispit.addIzlazakNaIspit(izlazakNaIspit);
        ispit.addIzlazakNaIspit(izlazakNaIspit1);


        //ispitni rok
        ispitniRok.setDatumPocetka("14.06.2021");
        ispitniRok.setDatumZavrsetka("20.06.2021");
        ispitniRok.addIspit(ispit);

        //izlazak na Ispit
        izlazakNaIspit.setNapomena("Sta god");
        izlazakNaIspit.setIzasaoNaIspit(true);
        izlazakNaIspit.setPonistavanje(false);
        izlazakNaIspit.setBrojOsvojenihPoena(95);
        izlazakNaIspit.setPrijavljenIspit(prijavaIspita);
        izlazakNaIspit.setPolozioPredmet(polozioPredmet);
        //izlazakNaIspit.setIspit(ispit);

        izlazakNaIspit1.setNapomena("Staaaaaa god");
        izlazakNaIspit1.setIzasaoNaIspit(true);
        izlazakNaIspit1.setPonistavanje(false);
        izlazakNaIspit1.setBrojOsvojenihPoena(90);
        izlazakNaIspit1.setPrijavljenIspit(prijavaIspita);
        izlazakNaIspit1.setPolozioPredmet(polozioPredmet);
        //izlazakNaIspit1.setIspit(ispit);

        //prijavaIpsita
        prijavaIspita.setDatum(LocalDate.now());
        prijavaIspita.setIzlazakNaIspit(izlazakNaIspit);

        //Upis godine
        upisGodina.setDatum(2020);
        upisGodina.setSkolskaGodina(skolskaGodina);
        upisGodina.setNapomena("napomena");

        //Obnova godine
        obnovaGodina.setDatum(2020);
        obnovaGodina.setNapomena("Napomena");
        obnovaGodina.setSkolskaGodina(skolskaGodina);
        obnovaGodina.setStudentIndeks(studIndex);
        obnovaGodina.addPredmetPrenos(predmet);
        obnovaGodina.addPredmetPrenos(predmet);

        //Skolska godina
        skolskaGodina.setDatum(2019);
        skolskaGodina.setAktivna(true);
        skolskaGodina.addIspitniRok(ispitniRok);


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
        predmet.addIspiti(ispit);
        predmet.addPredIspitne(predispitneObaveze);
        predmet.addPredIspitne(predispitneObaveze1);


        //studProg
        studProgram.addVrstaStudija(vrstaStudija);
        studProgram.addPredmet(predmet);
        studProgram.setGodinaAkreditacije(LocalDate.now());
        studProgram.setNaziv("Inzinjerstvo");
        studProgram.setSkraceniNaziv("RI");
        studProgram.setNazivZvanja("Diplomirani inzinjer");
        studProgram.setTrajanje(8);
        studProgram.addStudIndex(studIndex);

        //polozioPred
        polozioPredmet.setOcena(8);
        polozioPredmet.addPredmet(predmet);
        polozioPredmet.setPriznatSaDrugogFaksa(false);
        polozioPredmet.setUkupanBrojPoena(60);
        polozioPredmet.setIzlazakNaIspit(izlazakNaIspit);

        //index
        studIndex.setGodina(2018);
        studIndex.setAktivan(true);
        studIndex.setBroj(50);
        studIndex.setOdKadJeAktivan(LocalDate.now());
        studIndex.addPolozioPredmet(polozioPredmet);
        studIndex.addUpisGodina(upisGodina);
        studIndex.addObnovaGodine(obnovaGodina);
        studIndex.addOsvojeniPoeni(osvojeniPredispitniPoeni);
        studIndex.addSlusaPred(slusaPredmet);
        studIndex.addPrijavaIspita(prijavaIspita);

        //srednja sk
        srednjaSkola.setMesto("Obrenovac");
        srednjaSkola.setNaziv("Gimnazija u Obrenovcu");
        srednjaSkola.setVrsta("Gimnazija");
        srednjaSkola.addStudent(s);

        //visoka skola
        visokaSkola.setNaziv("visa etf");
        visokaSkola.setMesto("Beograd");
        visokaSkola.setVrsta("visoka skola");
        visokaSkola.addStudent(s);

        //student
        s.setIme("Luka");
        s.setPrezime("Lukovic");
        s.setSrednjeIme("Luk");
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
        s.setUspehSrednjaSKola(4.52);

        //studRepo.save(s);

        //upit izvlacenje studenta preko broja indeksa
//         Student student = studRepo.selectStudentByIndex(57);
//        System.out.println(student);

        //upit selekcija svih položenih ispita preko broja indeksa studenta
//         List<PolozioPredmet> polozioPredmeti = studRepo.selectPolozeniPredByIndex(57);
//        for(PolozioPredmet pred : polozioPredmeti){
//            System.out.println(pred);
//        }

        //upit selekcija studenta koristeci ime ili prezime ili ime i prezime
//         List<Student> studenti = studRepo.findStudentByNameAndSurname("nikola", null);
//         for(Student student : studenti){
//             System.out.println(student);
//         }

        //upit selekcija studenata koji su zavrsili odredjenu srednju skolu
//        List<Student> studenti = studRepo.findStudentByHighSchool("gimnazija u obrenovcu");
//        for(Student student : studenti){
//             System.out.println(student);
//         }

        //pregled svih upisanih godina za broj indeksa
//         List<UpisGodina> upisaneGodine = studRepo.findUpisaneGodineByIndex(57);
//         for(UpisGodina upis : upisaneGodine){
//             System.out.println(upis);
//         }

        //pregled obnovljenih godina za broj indeksa
//        List<ObnovaGodina> obnovaGodine = studRepo.findObnovljeneGodineByIndex(57);
//        for (ObnovaGodina obnova : obnovaGodine) {
//            System.out.println(obnova);
//        }
    }
}

