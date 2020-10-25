package studsluzba.jpatest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import studsluzba.model.Predmet;
import studsluzba.repositories.StudProgramRepository;
import studsluzba.repositories.StudentRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudProgramRepositoryTest {


    @Autowired
    StudProgramRepository studProgramRepo;

    @Test
    public void studPrgoramTest() throws Exception {


        List<Predmet> predmeti = studProgramRepo.selectPredmetiByStudProg("RN");
        System.out.println(predmeti);

    }


}
