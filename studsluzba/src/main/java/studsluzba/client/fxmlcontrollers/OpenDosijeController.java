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
public class OpenDosijeController {

    @Autowired
    DosijeService dosijeService;

    @Autowired
    FindStudentController findStudentController;

    @Autowired
    OpenTokStudijaController openTokStudijaController;

    @Autowired
    MainViewManager mainViewManager;

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
    Text polozeniPredmeti;

    @FXML
    Text slusaniPredmeti;

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


    public void handleOpenTokStudija(ActionEvent ae) {
        openTokStudijaController.student = student;
        // TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojećih ?? strani ključ
        mainViewManager.openModal("openTokStudija");
    }

    public void updateStundetData(Student student) {
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
        List<PolozioPredmet> polozeniLista = new ArrayList<>();
        List<StudIndex> indeksi = new ArrayList<>();
        List<SlusaPredmet> slusaLista = new ArrayList<>();
        indeksi = student.getIndexi();
        for (StudIndex i : indeksi) {
            polozeniLista.addAll(dosijeService.getPolozeni(i.getStudProgram().getSkraceniNaziv(), i.getBroj(), i.getGodina()));
        }
        polozeniPredmeti.setText(polozeniLista.toString());
        for (StudIndex i : indeksi) {
            slusaLista.addAll(dosijeService.getSlusa(i.getStudProgram().getSkraceniNaziv(), i.getBroj(), i.getGodina()));
        }
        // TODO Ne ispisivati predmete koji su polozeni
        slusaniPredmeti.setText(slusaLista.toString());

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
