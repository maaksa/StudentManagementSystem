package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.services.IspitiService;
import studsluzba.services.SifarniciService;
import studsluzba.services.SlusaPredmetService;

import java.time.LocalDate;
import java.util.List;

@Component
public class AddDrziPredmetController {

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    SlusaPredmetService slusaPredmetService;

    @Autowired
    NewSlusaPredmetController newSlusaPredmetController;

    //todo
    @FXML
    ComboBox<SkolskaGodina> skolskaGodinaCb = new ComboBox<>();

    //todo
    @FXML
    ComboBox<Nastavnik> nastavnikCb = new ComboBox<>();

    //todo
    @FXML
    ComboBox<Predmet> predmetCb = new ComboBox<>();

    @FXML
    TextField sifraDrziPredTf;


    @FXML
    public void addDrzi(ActionEvent event) {
        SkolskaGodina skolskaGodina = skolskaGodinaCb.getValue();
        Nastavnik nastavnik = nastavnikCb.getValue();
        Predmet predmet = predmetCb.getValue();
        String sifra = sifraDrziPredTf.getText();

        slusaPredmetService.addDrziPredmet(skolskaGodina, nastavnik, predmet, sifra);

        newSlusaPredmetController.updateDrziPredmet();

        closeStage(event);
    }



    @FXML
    public void initialize() {
        List<Predmet> predmetList = sifarniciService.getPredmeti();
        predmetCb.setItems(FXCollections.observableArrayList(predmetList));

        List<Nastavnik> nastavnikList = sifarniciService.getNastavnici();
        nastavnikCb.setItems(FXCollections.observableArrayList(nastavnikList));

        List<SkolskaGodina> skolskeLista = FXCollections.observableList(sifarniciService.getSkolskeGodine());
        skolskaGodinaCb.setItems(FXCollections.observableArrayList(skolskeLista));
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}