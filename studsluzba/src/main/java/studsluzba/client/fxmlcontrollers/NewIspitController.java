package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.services.IspitiService;
import studsluzba.services.NastavnikService;

@Component
public class NewIspitController {

    @Autowired
    IspitiService ispitiService;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    MainViewManager mainViewManager;

    @Autowired
    OpenPodaciOIspituController openPodaciOIspituController;

    @FXML
    DatePicker datumOdrzavanja;

    @FXML
    TextField sifraIspita;

    @FXML
    TextField vremePocetka;

    @FXML
    ComboBox ispitniRok;

    @FXML
    ComboBox predmet;

    @FXML
    ComboBox nastavnik;

    @FXML
    private TableView<Ispit> ispitiTable = new TableView<>();

    private ObservableList<Predmet> predmeti;
    private ObservableList<Nastavnik> nastavnici;

    @FXML
    protected void initialize() {

        nastavnici = FXCollections.observableList(nastavnikService.getNastavnici());
        nastavnik.setItems(nastavnici);

    }


    public void handleOpenPodaci(ActionEvent ae) {
        openPodaciOIspituController.ispit = ispitiTable.getSelectionModel().getSelectedItem();
        mainViewManager.openModal("addIspitniRok");
    }

}
