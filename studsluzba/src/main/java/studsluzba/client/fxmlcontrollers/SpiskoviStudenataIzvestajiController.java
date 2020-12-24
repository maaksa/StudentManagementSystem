package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.reports.ReportsManager;
import studsluzba.model.*;
import studsluzba.services.IzlazakNaIspitService;
import studsluzba.services.PrijavaIspitaService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;

import java.time.Clock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpiskoviStudenataIzvestajiController {

    @Autowired
    ReportsManager reportsManager;

    @FXML
    ComboBox<StudProgram> studProgramiCb;

    @FXML
    ComboBox<Predmet> predmetiCb;

    @FXML
    ComboBox<IspitniRok> ispitniRokoviCb;

    @Autowired
    StudProgramService studProgramiService;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    IzlazakNaIspitService izlazakNaIspitService;

    @FXML
    public void initialize() {

        List<Predmet> predmetList = sifarniciService.getPredmeti();
        predmetiCb.setItems(FXCollections.observableArrayList(predmetList));

        List<IspitniRok> ispitniRokList = sifarniciService.getIspitniRokovi();
        ispitniRokoviCb.setItems(FXCollections.observableArrayList(ispitniRokList));

        // System.out.println(ispitniRokList.size());   = 243
    }

    public void handleGenerisiSpisakPoStudProgramu(ActionEvent ecent) {
        List<TEST> sviIzlasci = new ArrayList<>();

        Map<String, Object> params = new HashMap<String, Object>(); //naziv parametra , vrednost parametra (treba da nam bude istog naziva kao naziv koji smo dali tom parametru studProgram

        Predmet predmet = predmetiCb.getValue();
        IspitniRok rok = ispitniRokoviCb.getValue();
        List<Student> studenti = izlazakNaIspitService.prijaveljeniStudenti(predmet,rok);

        List<PrijavaIspita> prijaveIspita = izlazakNaIspitService.prijave(predmet, rok);
        PrijavaIspita prijava = prijaveIspita.get(0);
        String vremeOdrzavanja = prijava.getIspit().getVremePocetka().toString();
        String datumOdrzavanja = prijava.getIspit().getDatumOdrzavanja().toString();
        String ispitniRok = rok.getDatumPocetka() + "-" + rok.getDatumZavrsetka();
        String skolskaGod = rok.getSkolskaGod().toString();

        String imePredmeta = predmet.getNazivPredmeta();
        String sifraPredmeta = predmet.getSifraPredmeta();

        for(PrijavaIspita p : prijaveIspita){
            TEST t = new TEST();
            t.setIme(p.getStudIndexi().getStudent().getIme());
            t.setPrezime(p.getStudIndexi().getStudent().getPrezime());
            t.setStudIndex(p.getStudIndexi().toString());
            t.setBrojPoena(p.getIzlazakNaIspit().getPolozioPredmet().getUkupanBrojPoena());
            t.setOcena(p.getIzlazakNaIspit().getPolozioPredmet().getOcena());
            sviIzlasci.add(t);

            System.out.println(t.getIme() + '\n');
            System.out.println(t.getPrezime() + '\n');
            System.out.println(t.getStudIndex() + '\n');
            System.out.println(t.getBrojPoena() + '\n');
            System.out.println(t.getOcena() + '\n');
        }




        List<DrziPredmet> drziPredmeti = sifarniciService.getDrziPredmeti();
        Nastavnik nastavnik = null;
        for(DrziPredmet d : drziPredmeti){
            if(d.getPredmet().getNazivPredmeta().equals(imePredmeta)){
                nastavnik = d.getNastavnik();
            }
        }
        int sifraNastavnika = nastavnik.getIdNastavnik();
        String imeNastavnika = nastavnik.getIme() + " " + nastavnik.getSrednjeIme() + " " + nastavnik.getPrezime();
        params.put("sifraPredmeta", sifraPredmeta);
        params.put("imePredmeta", imePredmeta);
        params.put("imeNastavnika", imeNastavnika);
        params.put("sifraNastavnika", sifraNastavnika);
        params.put("datumOdrzavanja", datumOdrzavanja);
        params.put("ispitniRok", ispitniRok);
        params.put("vremeOdrzavanja", vremeOdrzavanja);
        params.put("skolskaGod", skolskaGod);

        //reportsManager.openReport(studenti, params, "spisakStudenataZaStudProgram");
        reportsManager.openReport(sviIzlasci, params, "spisakStudenataZaStudProgram");
    }

}
