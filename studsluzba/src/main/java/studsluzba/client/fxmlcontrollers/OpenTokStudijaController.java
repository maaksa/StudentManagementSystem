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
import studsluzba.model.PolozioPredmet;
import studsluzba.model.SlusaPredmet;
import studsluzba.model.StudIndex;
import studsluzba.model.Student;
import studsluzba.services.DosijeService;

import java.util.ArrayList;
import java.util.List;

@Component
public class OpenTokStudijaController {


    //imamo sifarnik servic posto cemo preko njega da dodamo novu srednju skolu
    //spring nam omogucava da injectujemo ovu klasu preko @autowierd i da tu klasu koristimo u ovoj klasi
    @Autowired
    DosijeService dosijeService;

    @Autowired
    FindStudentController findStudentController;

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
    RadioButton radioButtonUpis;

    @FXML
    RadioButton radioButtonObnova;

    @FXML
    TableView programiTable;




    @FXML
    public void addStudent(ActionEvent event) {
        Student ss = new Student();
        dosijeService.saveStudent(ss);
        //update sa novom sr skolom
      //  findStudentController.updateSrednjeSkole();
        closeStage(event);
    }


    public void updateStundetData(Student student) {

    }

     @FXML
    public void initialize() {
         updateStundetData(student);

    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
