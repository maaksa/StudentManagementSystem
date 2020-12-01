package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.Ispit;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.services.IspitiService;
import studsluzba.services.StudProgramService;

import java.util.List;

@Component
public class IspitController {

    @Autowired
    IspitiService ispitiService;

    @Autowired
    MainViewManager mainViewManager;

    @Autowired
    OpenPodaciOIspituController openPodaciOIspituController;

    @FXML
    private TableView<Ispit> ispitiTable = new TableView<>();

    private ObservableList<Ispit> sviIspiti;

    @FXML
    protected void initialize() {
        sviIspiti = FXCollections.observableList(ispitiService.getIspiti());
        ispitiTable.getItems().clear();
        ispitiTable.setItems(sviIspiti);
    }


    public void handleOpenPodaci(ActionEvent ae) {
        openPodaciOIspituController.ispit = ispitiTable.getSelectionModel().getSelectedItem();
        mainViewManager.openModal("openPodaciMain");
    }

}
