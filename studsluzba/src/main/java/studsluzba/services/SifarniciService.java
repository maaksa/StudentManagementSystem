package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.SrednjaSkola;
import studsluzba.repositories.SrednjaSkolaRepository;

import java.util.ArrayList;
import java.util.List;

//bavice nam se svim sifarnicima
@Service
public class SifarniciService {

    @Autowired
    SrednjaSkolaRepository srednjaSkolaRepository;

    public List<SrednjaSkola> getSrednjeSkole() {
        //iz repo sr skola izvucicemo iz baze sve srednje skole i vracamo tu listu controlleru koji je pozvao ovu metodu
        Iterable<SrednjaSkola> iter = srednjaSkolaRepository.findAll();
        List<SrednjaSkola> rez = new ArrayList<SrednjaSkola>();
        iter.forEach(rez::add);
        return rez;
    }

    public SrednjaSkola saveSrednjaSkola(SrednjaSkola ss) {
        return srednjaSkolaRepository.save(ss);
    }
}
