package studsluzba.client.fxmlcontrollers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.client.MainViewManager;

@Component
public class MenuBarController {

    //anotacija da nam iz spring konteksta (spring u pozadini sve radi) uzme obj ove klase (ima @Component) i postavi ga ovde za
    //ovu klasu da mozemo da ga korsitimo
    //za menjanje scena ne menjamo MainViewManager
    @Autowired
    MainViewManager mainViewManager;

    @FXML
    private MenuBar menuBar;

    public void findStudent(ActionEvent event) {
        mainViewManager.changeRoot("findStudent");
    }

    //naziv metode koja se poziva u menuBar.fxml
    public void openStudProgrami(ActionEvent event) {
        //kad zelimo da promenimo scenu nama treba MainViewManager posto
        // nam on ima metode za menjanje scene, i onda do obj te klase dolazimo tako sto preko springa uradimo dependency injection
        // preko anotacije @Autowired
        mainViewManager.changeRoot("studProgrami");
    }

    public void openNewStudent(ActionEvent event) {
        mainViewManager.changeRoot("newStudent");
    }

    public void newSlusaPredmet(ActionEvent event) {
        mainViewManager.changeRoot("newSlusaPredmet");
    }

    public void newIspit(ActionEvent event) {
        mainViewManager.changeRoot("newIspit");
    }

    public void findNastavnik(ActionEvent event) {
        mainViewManager.changeRoot("findNastavnik");
    }

    public void findIspit(ActionEvent event) {
        mainViewManager.changeRoot("findIspit");
    }

    public void findStudProgram(ActionEvent event) {
        mainViewManager.changeRoot("findStudProgram");
    }

    public void openSearchStudent(ActionEvent event) {
        mainViewManager.changeRoot("searchStudent");
    }

}
