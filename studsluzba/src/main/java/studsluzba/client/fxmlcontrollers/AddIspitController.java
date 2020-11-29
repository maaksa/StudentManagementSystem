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
import studsluzba.model.Ispit;
import studsluzba.model.SrednjaSkola;
import studsluzba.services.IspitiService;
import studsluzba.services.SifarniciService;

import java.util.List;

@Component
public class AddIspitController {


    //imamo ispit servic posto cemo preko njega da dodamo nov ispit
    //spring nam omogucava da injectujemo ovu klasu preko @autowierd i da tu klasu koristimo u ovoj klasi
    @Autowired
    IspitiService ispitiService;

    @Autowired
    IspitController ispitController;

    @FXML
    TextField sifraIspitaTf;


    //akcija koja nam se izvrsava kad u fxml fajlu kome pripada ovaj controller pozovemo akciju #addSrednjaSkola
    @FXML
    public void addIspit(ActionEvent event) {
        Ispit ss = new Ispit();
        ss.setSifraIspita(sifraIspitaTf.getText());
        closeStage(event);
    }

    //ovde inicijalizujemo sta ce nam se prikazati u combo boxevima za fxml modal tj fxml fajl kome ovaj Controller pripada
    @FXML
    public void initialize() {

    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
