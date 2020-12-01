package studsluzba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studsluzba.model.SrednjaSkola;
import studsluzba.repositories.SrednjaSkolaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SifarniciService {

    @Autowired
    SrednjaSkolaRepository srednjaSkolaRepository;

    public List<SrednjaSkola> getSrednjeSkole() {
        Iterable<SrednjaSkola> iter = srednjaSkolaRepository.findAll();
        List<SrednjaSkola> rez = new ArrayList<SrednjaSkola>();
        iter.forEach(rez::add);
        return rez;
    }

    public SrednjaSkola saveSrednjaSkola(SrednjaSkola ss) {
        return srednjaSkolaRepository.save(ss);
    }
}
