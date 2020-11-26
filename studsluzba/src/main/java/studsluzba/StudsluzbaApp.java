package studsluzba;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import studsluzba.client.MainViewManager;

@SpringBootApplication
@EnableJpaRepositories
public class StudsluzbaApp extends Application {

    //integrisemo spring javafx
    //sluzi nam kao memorija u koju stavljamo neke obj i iz koje mozemo da ih uzmemo preko dependency injectiona
    //i ovom contextu cela app moze da pristupi
    //on nam je glavni, ako zelimo da napravimo neku view klasu, obj te
    //klase kad napravimo stavicemo u context i kad god nam treba izvucicemo ga iz konteksta
    //slicno kao singlton, obj se jednom napravi i stavi se u kontekst i pristupa se jednom obj iz konteksta(preko injectiona)
    protected ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(StudsluzbaApp.class);
    }

    ///////////////////////////////
    //zivotni ciklusi app, metode iz klase Application

    @Override
    public void init() throws Exception {
        //kreiramo springContext, kada nam se inicijalizuje javafx app, runujemo Spring
        springContext = SpringApplication.run(StudsluzbaApp.class);
    }

    @Override
    public void stop() throws Exception {
        //zatvaramo springContext
        springContext.close();
        //da nam se ugasi app
        Platform.exit();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("RAF Studentska sluzba");
        //trebamo da loadujemo prvu scenu, da nam se otvori neka ekranska forma
        //mozemo iz konteksta da uzmemo taj obj posto ima anotaciju @Component
        //getBean isto kao i anotacija @Autowired, getBean koristimo ako nam je taj obj potreban samo u nekoj metodi ne u celoj klasi
        MainViewManager mainView = springContext.getBean(MainViewManager.class);
        primaryStage.setScene(mainView.createScene());
        primaryStage.show();
    }

}
