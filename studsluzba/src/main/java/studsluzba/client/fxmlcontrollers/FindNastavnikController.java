package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.*;
import studsluzba.services.NastavnikService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class FindNastavnikController {

    @Autowired
    StudentService studentService;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    StudProgramService studProgramService;

    @Autowired
    MainViewManager mainViewManager;

    @Autowired
    OpenDosijeController openDosijeController;

    private Zvanje zvanje;

    @FXML
    private TextField imeTf;

    @FXML
    private TextField prezimeTf;


    @FXML
    private TextField nazivZvanja;

    @FXML
    private TextField uzaNaucnaOblast;

    @FXML
    private DatePicker datumIzbora;

    private ObservableList<Nastavnik> sviNastavnici;
    private ObservableList<DrziPredmet> sviDrziPredmeti;

    @FXML
    private ComboBox<SkolskaGodina> skolskaGodinaCb = new ComboBox<>();

    //todo
    @FXML
    private TableView<Nastavnik> nastavnikTable = new TableView<Nastavnik>();

    @FXML
    private TableView<DrziPredmet> drziPredmetTable = new TableView<DrziPredmet>();


    @FXML
    public void initialize() {
        List<SkolskaGodina> skolskeLista = FXCollections.observableList(sifarniciService.getSkolskeGodine());
        skolskaGodinaCb.setItems(FXCollections.observableArrayList(skolskeLista));
        updateNastavniciTable();
    }

    public void addZvanje(ActionEvent ae) {
        Nastavnik nastavnikSelected = nastavnikTable.getSelectionModel().getSelectedItem();
        String nastavnikNazivZvanja = nazivZvanja.getText();
        String nastavnikUzaNaucObla = uzaNaucnaOblast.getText();
        LocalDate nastavnikDatumIzbora = datumIzbora.getValue();

        nastavnikService.addZvanje(nastavnikNazivZvanja, nastavnikUzaNaucObla, nastavnikDatumIzbora, nastavnikSelected);
        updateNastavniciTable();
    }

    public void findNastavnik(ActionEvent ae) {
        SkolskaGodina skolskaGodina = skolskaGodinaCb.getValue();
        List<DrziPredmet> drziPredmetList = nastavnikService.findNastavnikBySk(skolskaGodina);
        drziPredmetTable.setItems(FXCollections.observableArrayList(drziPredmetList));
    }

    public void addNewDrzi(ActionEvent ae) {
        mainViewManager.openModal("addDrziPredmet");
    }

    public void updateDrziPredmet() {
        SkolskaGodina skolskaGodina = skolskaGodinaCb.getValue();
        List<DrziPredmet> drziPredmetList = nastavnikService.findNastavnikBySk(skolskaGodina);
        drziPredmetTable.setItems(FXCollections.observableArrayList(drziPredmetList));
    }

    public void updateDrziTable() {
        sviDrziPredmeti = FXCollections.observableList(sifarniciService.getDrziPredmeti());
        drziPredmetTable.getItems().clear();
        drziPredmetTable.setItems(sviDrziPredmeti);
        updateDrziPredmet();
    }

    public void updateNastavniciTable() {
        sviNastavnici = FXCollections.observableList(nastavnikService.getNastavnici());
        System.out.println(sviNastavnici);
        nastavnikTable.getItems().clear();
        nastavnikTable.setItems(sviNastavnici);
    }


}
