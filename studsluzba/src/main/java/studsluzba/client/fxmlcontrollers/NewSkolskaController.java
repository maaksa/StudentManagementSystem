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
import studsluzba.coders.CoderFactory;
import studsluzba.coders.CoderType;
import studsluzba.coders.SimpleCode;
import studsluzba.model.SkolskaGodina;
import studsluzba.model.SrednjaSkola;
import studsluzba.services.SifarniciService;
import studsluzba.services.SkolskaGodinaService;

@Component
public class NewSkolskaController {

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    SkolskaGodinaService skolskaGodinaService;

    @FXML
    TextField novaSkolska;

    @Autowired
    CoderFactory coderFactory;

    @FXML
    public void addSkolska(ActionEvent event) {
        SkolskaGodina skolska = new SkolskaGodina();
        if (novaSkolska.getText() != null){
            skolska.setDatum(Integer.parseInt(novaSkolska.getText()));
            skolska.setAktivna(true);

        }
        skolskaGodinaService.updateSkolskeGodine();
        sifarniciService.saveSkolska(skolska);
        novaSkolska.clear();

    }

    @FXML
    public void initialize() {

    }
}
