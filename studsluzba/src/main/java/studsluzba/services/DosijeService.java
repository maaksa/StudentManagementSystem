package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.SrednjaSkola;
import studsluzba.model.Student;
import studsluzba.repositories.SrednjaSkolaRepository;
import studsluzba.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

//bavice nam se svim sifarnicima
@Service
public class DosijeService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudenti() {
        //iz repo sr skola izvucicemo iz baze sve srednje skole i vracamo tu listu controlleru koji je pozvao ovu metodu
        Iterable<Student> iter = studentRepository.findAll();
        List<Student> rez = new ArrayList<Student>();
        iter.forEach(rez::add);
        return rez;
    }

    public Student saveStudent(Student ss) {
        return studentRepository.save(ss);
    }
}
