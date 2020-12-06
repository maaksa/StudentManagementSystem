package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
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
import studsluzba.services.SifarniciService;

import java.util.ArrayList;
import java.util.List;


@Component
public class OpenTokStudijaController {

    @Autowired
    DosijeService dosijeService;

    @Autowired
    FindStudentController findStudentController;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    MainViewManager mainViewManager;

    Student student;

    @FXML
    Text obnovaGodina;

    @FXML
    Text upisGodina;

    @FXML
    TextField novaGodina;


    @FXML
    ComboBox<SkolskaGodina> skolskaGodinaCb = new ComboBox<>();

    @FXML
    RadioButton radioButtonUpis;

    @FXML
    RadioButton radioButtonObnova;

    private ObservableList<Predmet> sviPredmeti;

    @FXML
    private TableView<Predmet> programiTable;

    @FXML
    public void initialize() {
        List<SkolskaGodina> skolskeLista = FXCollections.observableList(sifarniciService.getSkolskeGodine());
        skolskaGodinaCb.setItems(FXCollections.observableArrayList(skolskeLista));
        List<UpisGodina> upisGodinaList = new ArrayList<>();
        List<ObnovaGodina> obnovaGodinaList = new ArrayList<>();
        List<StudIndex> studIndexList = student.getIndexi();
        StudIndex aktivniIndex = new StudIndex();
        for (StudIndex i : studIndexList) {
            if (i.isAktivan()) {
                aktivniIndex = i;
            }
            upisGodinaList.addAll(dosijeService.getUpisGodina(i.getStudProgram().getSkraceniNaziv(), i.getBroj(), i.getGodina()));
            obnovaGodinaList.addAll(dosijeService.getObnovaGodina(i.getStudProgram().getSkraceniNaziv(), i.getBroj(), i.getGodina()));
        }
        upisGodina.setText(upisGodinaList.toString());
        obnovaGodina.setText(obnovaGodinaList.toString());

        sviPredmeti = FXCollections.observableList(dosijeService.getPredmetiZaStudProgram(aktivniIndex.getStudProgram().getSkraceniNaziv()));
        System.out.println(sviPredmeti);
        programiTable.setItems(sviPredmeti);

    }

    public void saveUpisObnova(ActionEvent ae) {
        Integer upisGodina = Integer.parseInt(novaGodina.getText());
        List<Predmet> predmetiSelected = programiTable.getSelectionModel().getSelectedItems();
        boolean upisObnovaRaddioB = radioButtonUpis.isSelected();
        List<StudIndex> studIndexList = student.getIndexi();
        StudIndex aktivniIndex = new StudIndex();

        for (StudIndex i : studIndexList) {
            if (i.isAktivan()) {
                aktivniIndex = i;
            }
        }

        if (upisObnovaRaddioB) {
            dosijeService.savaUpis(predmetiSelected, upisGodina, aktivniIndex);
        } else {
            System.out.println("usao");
            dosijeService.saveObnova(predmetiSelected, upisGodina, aktivniIndex);
        }
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
