package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.*;
import studsluzba.repositories.StudentRepository;

import java.time.LocalDate;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public Student save(String ime, String prezime, String srednje, long jmbg, LocalDate rodjenje, String mestoRodjenja, String nacionalnost,
                        String drzavaRodjenja, char pol, String licnaIzdao, String prelaz,
                        String drzavljanstvo, String licna, String adresaStanovanja, int brojUlice, long brojTelefona,
                        String privEmail, String mestoStanovanja, SrednjaSkola srednja,
                        double uspehSrednja, LocalDate datumUpisa, double uspehPrijemnni, String smer, int indeks, StudProgram program) {

        if (ime != null && prezime != null && srednje != null && rodjenje != null && mestoRodjenja
                != null && drzavaRodjenja != null && drzavljanstvo != null && licna != null && adresaStanovanja
                != null && mestoStanovanja != null && srednja != null && datumUpisa != null && smer != null) {

            String studEmail = null;
            boolean upisaoPrvuGodinu = true;
            VisokaSkola visokaSkola = null;
            System.out.println(srednja.getIdSrednjaSkola() + srednja.getNaziv());
            Student student = new Student(ime, prezime, srednje, jmbg, rodjenje, mestoRodjenja, drzavljanstvo, nacionalnost, pol,
                    mestoStanovanja, adresaStanovanja, brojUlice, brojTelefona, privEmail, studEmail, licna, licnaIzdao, upisaoPrvuGodinu,
                    uspehSrednja, uspehPrijemnni, prelaz, visokaSkola);

            //srednja.addStudent(student);
            student.setSrednjaSkola(srednja);

            System.out.println("JE L RADI OVO SERVICE");
            StudIndex studIndex = new StudIndex(indeks, datumUpisa.getYear(), true, datumUpisa, student, program);
            student.addIndex(studIndex);
            System.out.println(studIndex);

            try {
                return studentRepository.save(student);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }




        } else {
            System.out.println("JE L RADI OVO ELSE");
            return null;
        }

    }


}
