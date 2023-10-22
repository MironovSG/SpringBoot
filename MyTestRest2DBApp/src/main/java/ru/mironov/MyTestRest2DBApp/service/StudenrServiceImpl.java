package ru.mironov.MyTestRest2DBApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mironov.MyTestRest2DBApp.dao.StudentDAO;
import ru.mironov.MyTestRest2DBApp.entity.Student;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class StudenrServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        studentDAO.deleteStudent(id);
        return false;
    }
}

