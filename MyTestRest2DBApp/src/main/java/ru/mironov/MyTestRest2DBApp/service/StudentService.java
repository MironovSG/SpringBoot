package ru.mironov.MyTestRest2DBApp.service;

import org.springframework.stereotype.Service;
import ru.mironov.MyTestRest2DBApp.entity.Student;

import java.util.List;
@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    boolean deleteStudent(int id);
}
