package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.services.DosijeService;
import studsluzba.services.SifarniciService;

import java.util.List;

@Component
public class OpenDosijeController {


    //imamo sifarnik servic posto cemo preko njega da dodamo novu srednju skolu
    //spring nam omogucava da injectujemo ovu klasu preko @autowierd i da tu klasu koristimo u ovoj klasi
    @Autowired
    DosijeService dosijeService;

    @Autowired
    FindStudentController findStudentController;

    Student student;

    @FXML
    Text imeStudenta;

    @FXML
    Text prezimeStudenta;

    @FXML
    Text indeksStudenta;

    @FXML
    Text srednjeIme;

    @FXML
    Text jmbg;

    @FXML
     Text datumRodjenjaDp;

    @FXML
     Text emailTf;

    @FXML
     Text studemailTf;

    @FXML
     Text pol;

    @FXML
    Text brojTelefonaTf;

    @FXML
    Text ulica;

    @FXML
    Text mestoStanovanja;

    @FXML
    Text brojUlice;

    @FXML
    Text mestoRodjenja;

    @FXML
    Text drzavljanstvo;

    @FXML
    Text nacionalnost;

    @FXML
    Text brojLicneKarteTf;

    @FXML
    Text licnuKartuIzdaoTf;

    @FXML
    Text srednjeSkola;

    @FXML
    Text uspehSrednjaSkolaTf;

    @FXML
    Text uspehPrijemniTf;


    @FXML
    public void addStudent(ActionEvent event) {
        Student ss = new Student();
        dosijeService.saveStudent(ss);
        //update sa novom sr skolom
      //  findStudentController.updateSrednjeSkole();
        closeStage(event);

    }

     @FXML
    public void initialize() {
         imeStudenta.setText(student.getIme());
         prezimeStudenta.setText(student.getPrezime());
         indeksStudenta.setText(student.getIndexi().toString());
         srednjeIme.setText(student.getSrednjeIme());
         jmbg.setText(Long.toString(student.getJmbg()));
         datumRodjenjaDp.setText(student.getDaumRodjenja().toString());
         emailTf.setText(student.getPrivemail());
         studemailTf.setText(student.getStudemail());
         pol.setText(String.valueOf(student.getPol()));
         brojTelefonaTf.setText(Long.toString(student.getBrojTelefona()));
         ulica.setText(student.getUlica());
         mestoStanovanja.setText(student.getMesto());
         brojUlice.setText(Integer.toString(student.getBrojUlice()));
         mestoRodjenja.setText(student.getMestoRodjenja());
         drzavljanstvo.setText(student.getDrzavljanstvo());
         nacionalnost.setText(student.getNacionalnost());
         brojLicneKarteTf.setText(student.getBrojLicneKarte());
         licnuKartuIzdaoTf.setText(student.getLicnuKartuIzdao());
         srednjeSkola.setText(student.getSrednjaSkola().toString());
         uspehSrednjaSkolaTf.setText(Double.toString(student.getUspehSrednjaSkola()));
         uspehPrijemniTf.setText(Double.toString(student.getUspehPrijemni()));

    }

    private void closeStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
