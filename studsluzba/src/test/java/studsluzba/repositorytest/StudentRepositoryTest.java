package studsluzba.repositorytest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

	//dobijamo od springa sve implementirane metode
	@Autowired
	StudentRepository studentRepo;
	
	//testiramo da li radi
	@org.junit.Test
	public void saveStudentTest() {
		Student s = new Student();
		s.setIme("Nikola");
		s.setPrezime("Paunovic");
		s.setGodinaUpisa(2018);
		studentRepo.save(s);

	}

}
