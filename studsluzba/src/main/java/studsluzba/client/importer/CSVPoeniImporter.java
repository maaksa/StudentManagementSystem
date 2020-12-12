package studsluzba.client.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import studsluzba.model.StudIndex;
import studsluzba.services.StudentService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class CSVPoeniImporter {

    @Autowired
    StudentService studentService;

    // vraca poruku
    public String importCSV(File f) {
        Scanner sc = null;
        StringBuilder poruka = new StringBuilder();

        try {
            sc = new Scanner(f, "UTF-8");
            sc.nextLine();
            sc.nextLine();
            sc.nextLine();
            int brojSacuvanihStudenata = 0;
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] delovi = line.split(",");
                String studProgram = delovi[0];
                int broj = Integer.parseInt(delovi[1]);
                int godina = Integer.parseInt(delovi[2]);
                String prezime = delovi[3];
                String ime = delovi[4];
                StudIndex si = studentService.getStudentIndeks(studProgram, broj, godina);
                if (si == null) {  // student ne postoji dodajemo ga, u realnom sistemu se ovo ne moze desiti
                    si = studentService.saveStudentAndIndex(ime, prezime, studProgram, broj, godina);
                    brojSacuvanihStudenata++;
                }

            }
            poruka.append("Broj sacuvanih studenata: ");
            poruka.append(brojSacuvanihStudenata);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            sc.close();

        }
        return poruka.toString();
    }

}
