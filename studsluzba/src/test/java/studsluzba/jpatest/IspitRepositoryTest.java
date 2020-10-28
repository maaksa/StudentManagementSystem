package studsluzba.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import studsluzba.model.StudIndex;
import studsluzba.repositories.IspitRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IspitRepositoryTest {

    @Autowired
    IspitRepository ispitRepository;

    @Test
    public void ispitTest() throws Exception {

        //svi prijavljeni studenti za ispit
       /* List<StudIndex> studIndeksi = ispitRepository.findStudentsRegisteredForExam(1);
        System.out.println(studIndeksi);*/

        //prosečna ocena na ispitu
        Float avg = ispitRepository.getAverageGradeOnTheExam("Softverske komponente");
        System.out.println(avg);
    }

}
