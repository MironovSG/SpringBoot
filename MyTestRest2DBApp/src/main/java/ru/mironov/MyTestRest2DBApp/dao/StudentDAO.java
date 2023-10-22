package ru.mironov.MyTestRest2DBApp.dao;

import org.springframework.stereotype.Repository;
import ru.mironov.MyTestRest2DBApp.entity.Student;

import java.util.List;

@Repository
public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}

