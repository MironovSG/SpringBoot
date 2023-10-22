package ru.mironov.MyTestRest2DBApp.service;

import org.springframework.stereotype.Service;
import ru.mironov.MyTestRest2DBApp.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDisciplines();
    Discipline getDiscipline(int id);
    Discipline saveDiscipline(Discipline discipline);
    boolean deleteDiscipline(int id);
}

