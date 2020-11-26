package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.SrednjaSkola;
import studsluzba.services.SifarniciService;

import java.util.List;

@Component
public class AddSrednjaSkolaController {


    //imamo sifarnik servic posto cemo preko njega da dodamo novu srednju skolu
    //spring nam omogucava da injectujemo ovu klasu preko @autowierd i da tu klasu koristimo u ovoj klasi
    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    StudentController studentController;

    @FXML
    TextField nazivNoveSrednjeSkoleTf;
    @FXML
    ComboBox<String> mestoNoveSrednjeSkoleCb;
    @FXML
    ComboBox<String> tipNoveSrednjeSkoleCb;


    //akcija koja nam se izvrsava kad u fxml fajlu kome pripada ovaj controller pozovemo akciju #addSrednjaSkola
    @FXML
    public void addSrednjaSkola(ActionEvent event) {
        SrednjaSkola ss = new SrednjaSkola();
        if (mestoNoveSrednjeSkoleCb.getValue() != null) ss.setMesto(mestoNoveSrednjeSkoleCb.getValue());
        ss.setNaziv(nazivNoveSrednjeSkoleTf.getText());
        if (tipNoveSrednjeSkoleCb.getValue() != null) ss.setVrsta(tipNoveSrednjeSkoleCb.getValue());
        sifarniciService.saveSrednjaSkola(ss);
        //update sa novom sr skolom
        studentController.updateSrednjeSkole();
        closeStage(event);


    }

    //ovde inicijalizujemo sta ce nam se prikazati u combo boxevima za fxml modal (dodavanje nove sr skole) tj fxml fajl kome ovaj Controller pripada
    @FXML
    public void initialize() {
        List<String> tipSrednjeSkoleCodes = List.of("gimnazija", "srednje strucna skola");
        tipNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(tipSrednjeSkoleCodes));
        List<String> mestaCodes = List.of("Beograd", "Kruševac", "Niš");
        mestoNoveSrednjeSkoleCb.setItems(FXCollections.observableArrayList(mestaCodes));
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
