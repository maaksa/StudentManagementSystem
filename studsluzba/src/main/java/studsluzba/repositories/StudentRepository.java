package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudIndex;
import studsluzba.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	@Query("select s from Student s where "
			+ "(:ime is null or lower(s.ime) like :ime) and "
			+ "(:prezime is null or lower(s.prezime) like :prezime)")
	Student findStudent(String ime, String prezime);

	@Query("select s from Student s where s.idStudent = (select k.student.idStudent from StudIndex k where k.broj = :br)")
	Student selectStudentByIndex(int br);


	//select * from hr.employees e join hr.departments d on (e.department_id = d.department_id)

}
