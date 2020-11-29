package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;

import java.awt.*;
import java.util.List;

@Component
public class SearchStudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    StudProgramService studProgramService;

    @Autowired
    MainViewManager mainViewManager;


    @FXML
    TextField imeTf;
    @FXML
    TextField prezimeTf;

    @FXML
    TextField brojIndeksaTf;
    @FXML
    ComboBox smerCB;

    @FXML
    public void initialize() {
        java.util.List<String> smerovi = List.of("RN", "RI", "RD");
        ObservableList<String> smeroviObservableList = FXCollections.observableArrayList(smerovi);
        smerCB.setItems(smeroviObservableList);
    }

}
