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

    //da bi mogli da pokupimo uneto u ekransku formu, ime mora biti isto kao ime koje smo zadali u fx:id u fxml fajlu
    @FXML
    private TextField nazivIspitaTf;

    @FXML
    private ComboBox ispitiCb;


    @FXML
    private TableView<Ispit> ispitiTable;

    //ova metoda se svaki put izvrsava kada se otvori ekranska forma ciji je ovo kontroler
    @FXML
    protected void initialize() {
        List<Ispit> ispiti = ispitiService.getIspiti();
        ispitiCb.setItems(FXCollections.observableArrayList(ispiti));

    }

    public void handleSaveStudProgram(ActionEvent event) {
        // TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojećih ?? strani ključ
        mainViewManager.openModal("addIspit");
    }


}
