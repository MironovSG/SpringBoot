package ru.mironov.MyTestRest2DBApp.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mironov.MyTestRest2DBApp.entity.Discipline;
import ru.mironov.MyTestRest2DBApp.dao.DisciplineDAO;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    @Autowired
    private DisciplineDAO disciplineDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines(){
        return disciplineDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int disid) { return disciplineDAO.getDiscipline(disid); }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline){
        return disciplineDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public boolean deleteDiscipline(int disid) { disciplineDAO.deleteDiscipline(disid);
        return false;
    }
}

