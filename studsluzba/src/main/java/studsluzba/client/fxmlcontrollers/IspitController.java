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

    @FXML
    private TextField nazivIspitaTf;

    @FXML
    private ComboBox ispitiCb;


    @FXML
    private TableView<Ispit> ispitiTable;

    @FXML
    protected void initialize() {
//        List<Ispit> ispiti = ispitiService.getIspiti();
//        ispitiCb.setItems(FXCollections.observableArrayList(ispiti));

    }

    public void handleOpenPodaci(ActionEvent ae) {
        //  openDosijeController.student = studentiTable.getSelectionModel().getSelectedItem();
        // TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojećih ?? strani ključ
        mainViewManager.openModal("openPodaciMain");
    }

}
