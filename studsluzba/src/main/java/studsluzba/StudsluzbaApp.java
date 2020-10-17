package studsluzba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//imamo anotaciju jer smo ubacili maven dipendesije
@SpringBootApplication
@EnableJpaRepositories
public class StudsluzbaApp {

	public static void main(String[] args) {
		SpringApplication.run(StudsluzbaApp.class, args);

	}

}
