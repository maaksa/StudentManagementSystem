package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.Predmet;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.services.DosijeService;
import studsluzba.services.SifarniciService;

import java.util.List;

@Component
public class AddIspitniRokController {

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    DosijeService dosijeService;

    @Autowired
    StudentController studentController;

    @FXML
    DatePicker datumPocetka;

    @FXML
    DatePicker datumZavrsetka;

    @FXML
    ComboBox<SkolskaGodina> skolskaGodina;

    private ObservableList<SkolskaGodina> skolskeLista;


    @FXML
    public void addSrednjaSkola(ActionEvent event) {
//        SrednjaSkola ss = new SrednjaSkola();
//        if (mestoNoveSrednjeSkoleCb.getValue() != null) ss.setMesto(mestoNoveSrednjeSkoleCb.getValue());
//        ss.setNaziv(nazivNoveSrednjeSkoleTf.getText());
//        if (tipNoveSrednjeSkoleCb.getValue() != null) ss.setVrsta(tipNoveSrednjeSkoleCb.getValue());
//        sifarniciService.saveSrednjaSkola(ss);
//        studentController.updateSrednjeSkole();
//        closeStage(event);

    }


    @FXML
    public void initialize() {
        skolskeLista = FXCollections.observableList(dosijeService.getSkolskeGodine());
        skolskaGodina.setItems(skolskeLista);
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
