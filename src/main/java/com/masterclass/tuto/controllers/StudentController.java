package com.masterclass.tuto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masterclass.tuto.models.Student;
import com.masterclass.tuto.services.StudentService;

@RestController
@RequestMapping(path = "/api/v1/rest", name = "app_students_")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping(path = "/students", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student add(@RequestBody Student student){
        return this.studentService.saveStudent(student);
    }

    @GetMapping(path = "/students", name = "list")
    @ResponseStatus(HttpStatus.OK)
     List<Student> list(){
        return this.studentService.getAllStudent();
    }

    @GetMapping(path = "/students/{id}", name = "read")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student> read(@PathVariable Long id){
        return this.studentService.getOneStudent(id);
    }

    @PutMapping(path = "/students/{id}", name = "update")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student,  @PathVariable Long id){
        return this.studentService.updaStudent(student, id);
    }

    @DeleteMapping(path = "/students/{id}", name = "remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id){
       this.studentService.removeStudent(id);
    }
    
}
