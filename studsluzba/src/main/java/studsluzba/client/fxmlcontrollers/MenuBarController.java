package studsluzba.client.fxmlcontrollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
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


}