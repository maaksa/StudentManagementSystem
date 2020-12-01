package studsluzba.client.fxmlcontrollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.*;
import studsluzba.services.DosijeService;
import studsluzba.services.IspitiService;

import java.util.ArrayList;
import java.util.List;

@Component
public class OpenPodaciOIspituController {

    @Autowired
    IspitiService ispitiService;

    @Autowired
    IspitController ispitController;


    @Autowired
    MainViewManager mainViewManager;

    Student student;

    Ispit ispit;


    @FXML
    TableView<OsvojeniPredispitniPoeni> studRezultatiTable = new TableView<>();

    @FXML
    TableView<StudIndex> prijavljeniStudTable = new TableView<>();


    @FXML
    public void initialize() {

    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
