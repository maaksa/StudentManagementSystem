package studsluzba.client.fxmlcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.DrziPredmet;
import studsluzba.model.SlusaPredmet;
import studsluzba.model.StudIndex;
import studsluzba.services.IspitiService;
import studsluzba.services.NastavnikService;
import studsluzba.services.SifarniciService;
import studsluzba.services.SlusaPredmetService;

@Component
public class OpenViewSlusaPredmetController {

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
    TableView<SlusaPredmet> slusaTable = new TableView<>();


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


}
