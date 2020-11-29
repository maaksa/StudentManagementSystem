package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.services.SifarniciService;
import studsluzba.services.StudProgramService;
import studsluzba.services.StudentService;

import java.time.LocalDate;
import java.util.List;

@Component
public class FindStudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    SifarniciService sifarniciService;

    @Autowired
    StudProgramService studProgramService;

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
    private RadioButton radioButtonMuski;

    @FXML
    private RadioButton radioButtonZenski;

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

    //
    @FXML
    TextField pretragaBrojaIndeksaTf;

    @FXML
    TextField pretragaGodinaIndeksaTf;

    @FXML
    ComboBox pretragaSmerCb;

    @FXML
    TextField godinaIndeksaTf;

    @FXML
    ComboBox smerCb;

    @FXML
    TextField brojIndeksaTf;

    @FXML
    TextField NovaGodinaIndeksaTf;

    @FXML
    ComboBox NovSmerCb;

    @FXML
    TextField NovBrojIndeksaTf;

    @FXML
    TextField brojUliceTf;

    @FXML
    private TableView<Student> studentiTable;


    @FXML
    public void initialize() {
        List<String> findSmerovi = List.of("RN", "RI", "RD");
        ObservableList<String> smeroviObservableList1 = FXCollections.observableArrayList(findSmerovi);
        pretragaSmerCb.setItems(smeroviObservableList1);
        List<String> smerovi = List.of("RN", "RI", "RD");
        ObservableList<String> smeroviObservableList2 = FXCollections.observableArrayList(smerovi);
        smerCb.setItems(smeroviObservableList2);
        List<String> noviSmerovi = List.of("RN", "RI", "RD");
        ObservableList<String> smeroviObservableList3 = FXCollections.observableArrayList(noviSmerovi);
        NovSmerCb.setItems(smeroviObservableList3);

    }

    public void findStudentByName(ActionEvent event){
        String ime = imeTf.getText();
        String prezime = prezimeTf.getText();
        List<Student> studenti = studentService.students(ime, prezime);
        for(Student s : studenti){
            System.out.println(s.toString());
        }
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

    public void saveStudent(ActionEvent ae) {
        String ime = imeTf.getText();
        String prezime = prezimeTf.getText();
        String srednje = srednjeImeTf.getText();
        String jmbg = jmbgTf.getText();
        LocalDate rodjenje = datumRodjenjaDp.getValue();
        String mestoRodjenja = mestoRodjenjaCb.getValue();
        String drzavaRodjenja = drzavaRodjenjaCb.getValue();
        String drzavljanstvo = drzavljanstvoCb.getValue();
        String licna = brojLicneKarteTf.getText();
        String adresaStanovanja = adresaStanovanjaTf.getText();
        String mestoStanovanja = mestoStanovanjaCb.getValue();
        SrednjaSkola srednja = srednjeSkolaCb.getValue();
        String uspehSrednja = uspehSrednjaSkolaTf.getText();
        String uspehPrijemnni = uspehPrijemniTf.getText();
        LocalDate datumUpisa = datumUpisaDp.getValue();
        String smer = String.valueOf(smerCb.getValue().toString());
        String indeks = brojIndeksaTf.getText();
        String prelaz = prelazSaVisokoskolskeUstanoveTf.getText();
        String nacionalnost = nacionalnostTf.getText();
        String licnaIzdao = licnuKartuIzdaoTf.getText();
        String privEmail = emailTf.getText();
        String pol = radioButtonMuski.getText();
        String brojTelefona = brojTelefonaTf.getText();
        String brojUlice = brojUliceTf.getText();

        System.out.println("JE L RADI OVO STUDENT");

        StudProgram studProgram = null;

        List<StudProgram> programi = studProgramService.loadAll();
        for (StudProgram sp : programi) {
            if (sp.getSkraceniNaziv().equals(smer)) {
                studProgram = sp;
            }
        }

        System.out.println(studProgram);
        System.out.println(srednja);
        // PROBA KOMITA
        // Proba opet jos jedna

        Student studet = studentService.save(ime, prezime, srednje, Long.parseLong(jmbg), rodjenje, mestoRodjenja, nacionalnost, drzavaRodjenja,
                pol.charAt(0),
                licnaIzdao, prelaz, drzavljanstvo, licna, adresaStanovanja, Integer.parseInt(brojUlice), Long.parseLong(brojTelefona), privEmail,
                mestoStanovanja, srednja, Double.parseDouble(uspehSrednja), datumUpisa, Double.parseDouble(uspehPrijemnni), smer, Integer.parseInt(indeks), studProgram);

        System.out.println(studet.toString());

    }
}
