package studsluzba.client.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.*;
import studsluzba.services.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class CSVPoeniImporter {

    @Autowired
    StudentService studentService;

    @Autowired
    PredmetService predmetService;

    @Autowired
    SkolskaGodinaService skolskaGodinaService;

    @Autowired
    PredispitneObavezeService predispitneObavezeService;

    @Autowired
    OsvojeniPredispitniPoeniService osvojeniPredispitniPoeniService;

    @Autowired
    IspitiService ispitiService;

    @Autowired
    IspitniRokService ispitniRokService;

    @Autowired
    PrijavaIspitaService prijavaIspitaService;

    @Autowired
    PolozioPredmetService polozioPredmetService;

    @Autowired
    IzlazakNaIspitService izlazakNaIspitService;

    private Predmet predmet;
    private SkolskaGodina skolskaGodina;
    private Ispit ispit;

    public String importCSV(File f) {
        Scanner sc = null;
        ArrayList<String> predispitni = new ArrayList<>();
        ArrayList<String> ispitni = new ArrayList<>();
        StringBuilder poruka = new StringBuilder();

        try {
            sc = new Scanner(f, "UTF-8");

            //predmet
            String nazivPredmeta = sc.nextLine();
            String[] naziv = nazivPredmeta.split(",");
            predmet = predmetService.getPredmet(naziv[0]);

            //sk godina
            String skGodina = sc.nextLine();
            String[] skgod = skGodina.split(",");
            skolskaGodina = skolskaGodinaService.getSkolskaGodina(skgod[0]);

            //klk test kviz...
            String naslovObaveze = sc.nextLine();
            String[] deloviNaslovPredispitni = naslovObaveze.split(",");
            for (int i = 5; i < deloviNaslovPredispitni.length - 4; i++) {
                System.out.println(deloviNaslovPredispitni[i]);
                predispitni.add(deloviNaslovPredispitni[i]);
            }

            //jun jul avg sep
            String[] deloviNaslovIspiti = naslovObaveze.split(",");
            for (int i = deloviNaslovIspiti.length - 4; i < deloviNaslovIspiti.length; i++) {
                System.out.println(deloviNaslovIspiti[i]);
                ispitni.add(deloviNaslovIspiti[i]);
            }

            ispit = ispitiService.createIspit(predmet);

            int brojSacuvanihStudenata = 0;
            while (sc.hasNext()) {
                boolean polozio = false;
                double ukupnoPredispitnih = 0;
                double ukupniPoeni = 0;
                String line = sc.nextLine();
                String[] delovi = line.split(",");
                System.out.println("------------------------------------------------");
                String studProgram = delovi[0];
                int broj = Integer.parseInt(delovi[1]);
                int godina = Integer.parseInt(delovi[2]);
                String prezime = delovi[3];
                String ime = delovi[4];
                StudIndex si = studentService.getStudentIndeks(studProgram, broj, godina);
                if (si == null) {  // student ne postoji dodajemo ga, u realnom sistemu se ovo ne moze desiti
                    si = studentService.saveStudentAndIndex(ime, prezime, studProgram, broj, godina);
                    brojSacuvanihStudenata++;
                }

                OsvojeniPredispitniPoeni osvojeniPredispitniPoeni = osvojeniPredispitniPoeniService.createOsvojeniPredi(si);

                for (int i = 5; i < delovi.length; i++) {
                    if (delovi[i].isEmpty()) {
                        continue;
                    }
                    PredispitneObaveze predispitneObaveze;
                    PrijavaIspita prijavaIspita;
                    IzlazakNaIspit izlazakNaIspit;
                    IspitniRok ispitniRok;
                    PolozioPredmet polozioPredmet;
                    switch (i) {
                        case 5:
                            ukupnoPredispitnih += Double.parseDouble(delovi[i]);
                            predispitneObaveze = predispitneObavezeService.createPredispitne(Double.parseDouble(delovi[i]), predmet,
                                    predispitni.get(0), skolskaGodina, osvojeniPredispitniPoeni);
                            break;
                        case 6:
                            ukupnoPredispitnih += Double.parseDouble(delovi[i]);
                            predispitneObaveze = predispitneObavezeService.createPredispitne(Double.parseDouble(delovi[i]), predmet,
                                    predispitni.get(1), skolskaGodina, osvojeniPredispitniPoeni);
                            break;
                        case 7:
                            ukupnoPredispitnih += Double.parseDouble(delovi[i]);
                            predispitneObaveze = predispitneObavezeService.createPredispitne(Double.parseDouble(delovi[i]), predmet,
                                    predispitni.get(2), skolskaGodina, osvojeniPredispitniPoeni);
                            break;
                        case 8:
                            ispitniRok = ispitniRokService.createIspitniRok(skolskaGodina, ispitni.get(0), ispit);
                            prijavaIspita = prijavaIspitaService.createPrijava(ispit, si);
                            ukupniPoeni = ukupnoPredispitnih + Double.parseDouble(delovi[i]);
                            if (ukupniPoeni > 50) {
                                polozio = true;
                            }
                            polozioPredmet = polozioPredmetService.createPolozioPred(si, predmet, ukupniPoeni, polozio);
                            izlazakNaIspit = izlazakNaIspitService.createIzlazak(ispit, prijavaIspita, polozioPredmet, Double.parseDouble(delovi[i]));
                            break;
                        case 9:
                            ispitniRok = ispitniRokService.createIspitniRok(skolskaGodina, ispitni.get(1), ispit);
                            prijavaIspita = prijavaIspitaService.createPrijava(ispit, si);
                            ukupniPoeni = ukupnoPredispitnih + Double.parseDouble(delovi[i]);
                            if (ukupniPoeni > 50) {
                                polozio = true;
                            }
                            polozioPredmet = polozioPredmetService.createPolozioPred(si, predmet, ukupniPoeni, polozio);
                            izlazakNaIspit = izlazakNaIspitService.createIzlazak(ispit, prijavaIspita, polozioPredmet, Double.parseDouble(delovi[i]));
                            break;
                        case 10:
                            ispitniRok = ispitniRokService.createIspitniRok(skolskaGodina, ispitni.get(2), ispit);
                            prijavaIspita = prijavaIspitaService.createPrijava(ispit, si);
                            ukupniPoeni = ukupnoPredispitnih + Double.parseDouble(delovi[i]);
                            if (ukupniPoeni > 50) {
                                polozio = true;
                            }
                            polozioPredmet = polozioPredmetService.createPolozioPred(si, predmet, ukupniPoeni, polozio);
                            izlazakNaIspit = izlazakNaIspitService.createIzlazak(ispit, prijavaIspita, polozioPredmet, Double.parseDouble(delovi[i]));
                            break;
                        case 11:
                            ispitniRok = ispitniRokService.createIspitniRok(skolskaGodina, ispitni.get(3), ispit);
                            prijavaIspita = prijavaIspitaService.createPrijava(ispit, si);
                            ukupniPoeni = ukupnoPredispitnih + Double.parseDouble(delovi[i]);
                            if (ukupniPoeni > 50) {
                                polozio = true;
                            }
                            polozioPredmet = polozioPredmetService.createPolozioPred(si, predmet, ukupniPoeni, polozio);
                            izlazakNaIspit = izlazakNaIspitService.createIzlazak(ispit, prijavaIspita, polozioPredmet, Double.parseDouble(delovi[i]));
                            break;
                    }
                }

                System.out.println(ukupnoPredispitnih);
                osvojeniPredispitniPoeniService.updateUkupni(osvojeniPredispitniPoeni, ukupnoPredispitnih);

            }
            poruka.append("Broj sacuvanih studenata: ");
            poruka.append(brojSacuvanihStudenata);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
        return poruka.toString();
    }

}
