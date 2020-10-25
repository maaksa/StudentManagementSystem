package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import studsluzba.model.Predmet;
import studsluzba.model.StudProgram;

import java.util.List;

public interface StudProgramRepository extends CrudRepository<StudProgram, Integer> {

    @Query("select p from Predmet p where p.idPredmet = (select sp.idstudProgram from StudProgram sp where sp.skraceniNaziv like :skraceni_naziv)")
    List<Predmet> selectPredmetiByStudProg(String skraceni_naziv);
}
