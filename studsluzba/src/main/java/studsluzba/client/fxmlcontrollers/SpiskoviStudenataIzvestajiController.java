package studsluzba.client.fxmlcontrollers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.reports.ReportsManager;
import studsluzba.model.StudProgram;
import studsluzba.model.Student;
import studsluzba.services.StudProgramService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SpiskoviStudenataIzvestajiController {

    @Autowired
    ReportsManager reportsManager;

    @FXML
    ComboBox<StudProgram> studProgramiCb;

    @Autowired
    StudProgramService studProgramiService;

    @FXML
    public void initialize() {
        studProgramiCb.setItems(FXCollections.observableArrayList(studProgramiService.loadAll()));
    }

    public void handleGenerisiSpisakPoStudProgramu(ActionEvent ecent) {
        List<Student> studenti = studProgramiService.getStudentiNaProgramu(studProgramiCb.getValue());
        Map<String, Object> params = new HashMap<String, Object>(); //naziv parametra , vrednost parametra (treba da nam bude istog naziva kao naziv koji smo dali tom parametru studProgram)
        params.put("studProgram", studProgramiCb.getValue().getNaziv());
        reportsManager.openReport(studenti, params, "spisakStudenataZaStudProgram");
    }

}
