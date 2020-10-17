package studsluzba.jpatest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import studsluzba.model.Student;
import studsluzba.repositories.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	StudentRepository studRepo;
	
	@Test
    public void saveStudentTest() throws Exception {
        Student s = new Student();
        s.setIme("Misa");
        s.setPrezime("Misic");
        s.setSrednjeIme("Marko");
        studRepo.save(s);
    }
	
	@Test
    public void findStudentTest() throws Exception {        
        List<Student> studenti = studRepo.findStudent("misa", null);
        for(Student s:studenti)
        	System.out.println(s);
	}
        
   }

