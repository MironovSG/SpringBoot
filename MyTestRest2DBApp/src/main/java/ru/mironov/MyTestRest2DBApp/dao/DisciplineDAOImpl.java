package ru.mironov.MyTestRest2DBApp.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mironov.MyTestRest2DBApp.entity.Discipline;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class DisciplineDAOImpl implements DisciplineDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Discipline> getAllDisciplines(){
        Query query = entityManager.createQuery("from Discipline");
        List<Discipline> allDisciplines = query.getResultList();
        log.info("getAllDisciplines" + allDisciplines);
        return allDisciplines;
    }

    @Override
    public Discipline saveDiscipline(Discipline discipline){ return entityManager.merge(discipline); }

    @Override
    public Discipline getDiscipline(int disid){ return entityManager.find(Discipline.class, disid); }

    @Override
    public void deleteDiscipline(int disid) {
        Query query = entityManager.createQuery("delete from Discipline "
                + " where disid =:disciplineId");
        query.setParameter("disciplineId", disid);
        query.executeUpdate();
    }
}

