package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.StudProgram;
import studsluzba.services.StudProgramService;

@Component
public class StudProgramController {

    @Autowired
    StudProgramService studProgramService;

    //da bi mogli da pokupimo uneto u ekransku formu, ime mora biti isto kao ime koje smo zadali u fx:id u fxml fajlu
    @FXML
    private TextField nazivTf;
    @FXML
    private TextField skraceniNazivTf;

    //lista svih stud programa koji nam postoje u bazi, treba nam za tabelu da nam se automatski azurira tabela ako smo dodali nekog novog studenta itd
    private ObservableList<StudProgram> sviProgrami;

    @FXML
    private TableView<StudProgram> programiTable;

    //ova metoda se svaki put izvrsava kada se otvori ekranska forma ciji je ovo kontroler
    @FXML
    protected void initialize() {
        //ovde kreiramo observable listu objekata ove klase StudProgram, iz servica uzimamo sve studPrograme iz baze
        sviProgrami = FXCollections.observableList(studProgramService.loadAll());
        //setujemo tabeli view
        programiTable.setItems(sviProgrami);
    }

    public void handleSaveStudProgram(ActionEvent event) {
        //service ce nam vratiti sacuvani entitet koji mu je vratio repository i smesticemo ga u sp obj
        StudProgram sp = studProgramService.saveStudProgram(nazivTf.getText(), skraceniNazivTf.getText());
        //taj obj koji smo sacuvali preko repositorijuma dodajemo u listu svih stud programa kako bi nam se tabela azurirala sa novim podatcima
        sviProgrami.add(sp);
    }


}
