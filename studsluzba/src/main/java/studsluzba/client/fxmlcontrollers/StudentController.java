package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudentService;

import java.util.List;

@Component
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SifarniciService sifarniciService;


    @Autowired
    MainViewManager mainViewManager;

    // forma ce se koristiti za unos novog i za azuriranje postojeceg studenta
    private Student student;


    @FXML
    private TextField imeTf;
    @FXML
    private TextField prezimeTf;
    @FXML
    private TextField srednjeImeTf;
    @FXML
    private TextField jmbgTf;
    @FXML
    private DatePicker datumRodjenjaDp;
    @FXML
    private Text actionTarget;

    @FXML
    private TextField emailTf;


    @FXML
    TextField brojTelefonaTf;
    @FXML
    TextField adresaPrebivalistaTf;
    @FXML
    ComboBox<String> mestoPrebivalistaCb;
    @FXML
    TextField adresaStanovanjaTf;
    // TODO da li i mesta da idu preko sifarnika
    @FXML
    ComboBox<String> mestoStanovanjaCb;
    @FXML
    ComboBox<String> mestoRodjenjaCb;

    @FXML
    ComboBox<String> drzavaRodjenjaCb;

    @FXML
    ComboBox<String> drzavljanstvoCb;

    @FXML
    TextField nacionalnostTf;

    @FXML
    TextField brojLicneKarteTf;

    @FXML
    TextField licnuKartuIzdaoTf;

    // prvi upis

    //povezali smo comboBox sa onim iz fxml fajla kome pripada ovaj controller
    @FXML
    ComboBox<SrednjaSkola> srednjeSkolaCb;

    @FXML
    TextField strucnaSpremaTf;

    @FXML
    TextField uspehSrednjaSkolaTf;

    @FXML
    TextField uspehPrijemniTf;

    @FXML
    TextField godinaZavrsetkaSrednjeSkoleTf;

    @FXML
    TextField prelazSaVisokoskolskeUstanoveTf;

    @FXML
    TextField prethodnoZavrseneStudijeTf;

    @FXML
    TextField visokoskolskaUstanovaPrethodnihStudijaTf;

    @FXML
    TextField stecenoZvanjeTf;

    @FXML
    TextField prosecnaOcenaTf;

    @FXML
    DatePicker datumUpisaDp;

    @FXML
    TextArea napomenaTa;

    @FXML
    public void initialize() {
        //najbolje u resources fajlu imati txt fajl spiskova svih drzava i to da se ne menja, da ne cuvamo u bazi
        List<String> drzavaCodes = List.of("Republika Srbija", "Crna Gora", "Hrvatska");
        drzavaRodjenjaCb.setItems(FXCollections.observableArrayList(drzavaCodes));
        drzavaRodjenjaCb.setValue(new String("Republika Srbija"));
        drzavljanstvoCb.setItems(FXCollections.observableArrayList(drzavaCodes));
        drzavljanstvoCb.setValue(new String("Republika Srbija"));
        List<String> mestaCodes = List.of("Beograd", "Leskovac", "Vranje");
        ObservableList<String> mestaCodesObservableList = FXCollections.observableArrayList(mestaCodes);
        mestoPrebivalistaCb.setItems(mestaCodesObservableList);
        mestoRodjenjaCb.setItems(mestaCodesObservableList);
        mestoStanovanjaCb.setItems(mestaCodesObservableList);
        //sr skola nam predstavlja sifranik (sifarnik moze nam biti vrsta stduija, zvanja, sve ono sto smo unosili, sluze nam samo da ih vezemo za nesto u ovom sluc za studenta)
        //i sifarniciServica pozvacemo srSkoleRepo koji ce iz baze izvuci sve sr skole
        //srednjeSkoleCb ComboBox uvezan sa ComboBox iz fxml fajla kome pripada ovaj Controller, i na ovaj nacin napunimo(azuriramo) comboBox u fxml fajlu
        List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
        srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));

    }

    public void handleOpenModalSrednjeSkole(ActionEvent ae) {
        // TODO kreirati modal window za dodavanje nove srednje skole, mozda i brisanje i promena postojećih ?? strani ključ
        mainViewManager.openModal("addSrednjaSkola");
    }

    public void updateSrednjeSkole() {
        //uzimamo sr skole sa novom sr skolom koja je dodata
        List<SrednjaSkola> srednjeSkole = sifarniciService.getSrednjeSkole();
        //unosimo sr skole u combo box koji se nalazi u fxml kome pripada ovaj controller (newStudent.fxml)
        srednjeSkolaCb.setItems(FXCollections.observableArrayList(srednjeSkole));
    }
}
