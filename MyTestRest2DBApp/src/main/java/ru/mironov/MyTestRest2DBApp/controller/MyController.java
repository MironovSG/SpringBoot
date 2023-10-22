package ru.mironov.MyTestRest2DBApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mironov.MyTestRest2DBApp.entity.Student;
import ru.mironov.MyTestRest2DBApp.entity.Discipline;
import ru.mironov.MyTestRest2DBApp.service.DisciplineService;
import ru.mironov.MyTestRest2DBApp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DisciplineService disciplineService;
    @GetMapping("/students")
    public Object[] showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        Object[] res;
        String mes;
        List<Student> allStudents1 = studentService.getAllStudents();
        if(allStudents.isEmpty()) {
            mes = "no records in the database";
            res = new Object[1];
        } else {
            mes = "operation was completed successfully";
            res = new Object[2];
            res[1] = allStudents;
        }
        res[0] = mes;
        return res;
    }
    @GetMapping("/students/{id}")
    public Object[] getStudent(@PathVariable("id") int id) {
        Object[] res;
        String mes;
        Student student = studentService.getStudent(id);

        if(student == null) {
            mes = "record not found";
            res = new Object[1];
        } else {
            mes = "operation was completed successfully";
            res = new Object[2];
            res[1] = student;
        }
        res[0] = mes;
        return res;
    }
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) { return studentService.saveStudent(student); }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }
    @DeleteMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") int id) { studentService.deleteStudent(id); }
    @GetMapping("/disciplines")
    public Object[] showAllDisciplines(){
        Object[] res;
        String mes;
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        if(allDisciplines.isEmpty()) {
            mes = "no records in the database";
            res = new Object[1];
        } else {
            mes = "operation was completed successfully";
            res = new Object[2];
            res[1] = allDisciplines;
        }
        res[0] = mes;
        return res;
    }
    @GetMapping("/disciplines/{id}")
    public Object[] getDisciplines(@PathVariable("id") int disid) {
        Object[] res;
        String mes;
        Discipline discipline = disciplineService.getDiscipline(disid);
        if(discipline == null) {
            mes = "record not found";
            res = new Object[1];
        } else {
            mes = "operation was completed successfully";
            res = new Object[2];
            res[1] = discipline;
        }
        res[0] = mes;
        return res;
    }
    @PostMapping("/disciplines")
    public Discipline saveDiscipline(@RequestBody Discipline discipline) { return disciplineService.saveDiscipline(discipline); }
    @PutMapping("/disciplines")
    public Discipline updateDiscipline(@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return discipline;
    }
    @DeleteMapping("/disciplines/{id}")
    public void updateDiscipline(@PathVariable("id") int disid) { disciplineService.deleteDiscipline(disid); }
}

