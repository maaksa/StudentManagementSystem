package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.Nastavnik;
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;
import studsluzba.model.Zvanje;
import studsluzba.services.NastavnikService;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;

import java.time.LocalDate;
import java.util.List;

@Component
public class FindStudProgramController {

    @Autowired
    StudentService studentService;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    StudProgramService studProgramService;

    @Autowired
    MainViewManager mainViewManager;

    @FXML
    private TextField imeTf;

    @FXML
    private ComboBox pretragaSmerCb;

    private ObservableList<Predmet> sviPredmeti;

    @FXML
    private TableView<Predmet> studProgramTable = new TableView<Predmet>();

    @FXML
    public void initialize() {
        List<String> findSmerovi = List.of("RN", "RI", "RD");
        ObservableList<String> smeroviObservableList1 = FXCollections.observableArrayList(findSmerovi);
        pretragaSmerCb.setItems(smeroviObservableList1);
    }

    public void showStudProgPred(ActionEvent ae) {
        String smer = String.valueOf(pretragaSmerCb.getValue().toString());
        sviPredmeti = FXCollections.observableList(studProgramService.getPredmetiByProgram(smer));
        studProgramTable.getItems().clear();
        studProgramTable.setItems(sviPredmeti);
    }


}
