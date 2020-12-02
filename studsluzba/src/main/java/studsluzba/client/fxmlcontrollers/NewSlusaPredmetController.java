package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.*;
import studsluzba.services.IspitiService;
import studsluzba.services.NastavnikService;
import studsluzba.services.SifarniciService;
import studsluzba.services.SlusaPredmetService;

import java.time.LocalDate;
import java.util.List;

@Component
public class NewSlusaPredmetController {

    @Autowired
    IspitiService ispitiService;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    MainViewManager mainViewManager;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    SlusaPredmetService slusaPredmetService;

    @FXML
    TableView<StudIndex> indexiTable = new TableView<>();

    @FXML
    ComboBox<DrziPredmet> drziPredmetCb = new ComboBox<>();


    @FXML
    protected void initialize() {
       // List<Student> studentiLista = slusaPredmetService.loadAll();
      //  studentCb.setItems(FXCollections.observableArrayList(studentiLista));

//        List<DrziPredmet> drziLista = slusaPredmetService.getPredmeti();
//        drziPredmetCb.setItems(FXCollections.observableArrayList(drziLista));

    }

    public void openSlusaPredmet(ActionEvent ae) {

    }

    public void resetValues() {

    }

    public void updateIspitniRokovi() {

    }

    public void handleOpenDrziPredmet(ActionEvent ae) {
        mainViewManager.openModal("addDrziPredmet");
    }

    public void handleOpenSlusaPredmet(ActionEvent ae) {
        mainViewManager.openModal("openViewSlusaPredmet");
    }


}
