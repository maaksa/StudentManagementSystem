package studsluzba.client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
//kada i init metodi inicijalizujemo spring kontekst, spring ce u pozadini da skenira i sve
// klase koje imaju anotacije @Component @Controller @Service da ih kreira(kreirao objekat te klase) i da ih stavi u taj kontekst
//ova anotacija oznacava da ce objekat ove klase da nam napravi spring i da ih stavi u context i onda mozemo da injectujemo preko dependency injectiona
//service i controller su component kad stavimo ovakve anotacije kada inicijalizujemo u studApp on ce kreirati sve klase koje imaju ovu anotaciju
// ionda mozemo da koristimo te klase u studApp metoda start -> springContex.getBean(MinViewManager.class) kao singlton uzimamo jednu njegovu instancu
// i onda u bilo kom delu nase app mozemo da postavimo scenu
public class MainViewManager {


    @Autowired
    ContextFXMLLoader appFXMLLoader;

    private Scene scene;

    //ovu metodu smo pozvali u start metodi, prva scena koja nam se kreira
    public Scene createScene() {
        try {
            FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/main.fxml"));//loadujemo jedan
            // fxml fajl i onda ga on veze za neku controller kalsu, loadujemo iz resorce fajla(tu idu svi fajlovi koji nisu java kod)
            BorderPane borderPane = loader.load();
            this.scene = new Scene(borderPane);//stavicemo scenu na korenski layout tj borderPane
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.scene;
    }

    public void changeRoot(String fxml) {//menja korenski layout, prosledjujemo joj ime fxml fajla
        FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/" + fxml + ".fxml"));
        try {
            scene.setRoot(loader.load());//promenimo mu izgled ono sto smo loadovali iz fxml fajla koji smo prosledili getLoader metodi
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //pomocni prozor koji se pojavljuje iznad naseg glavnog prozora, njega cemo korstiti za dodavanje srednjih skola
    public void openModal(String fxml) {
        FXMLLoader loader = appFXMLLoader.getLoader(MainViewManager.class.getResource("/fxml/" + fxml + ".fxml"));
        try {
            Parent parent = loader.load();
            Scene scene = new Scene(parent, 900, 1000);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);//kazemo mu da je pomocni prozo ne glavni
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


