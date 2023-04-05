package com.masterclass.tuto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterclass.tuto.exceptions.StudentNotFoundException;
import com.masterclass.tuto.models.Student;
import com.masterclass.tuto.repository.StudentRepository;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }

    public List<Student> getAllStudent() {
        return this.studentRepository.findAll();
    }

    public Optional<Student> getOneStudent(Long id) {

        Optional<Student> studentExist = this.studentRepository.findById(id);

        if (!studentExist.isPresent()) {
            throw new StudentNotFoundException(String.format("student with id %s is not found", id));
        }

        return studentExist;
    }

    public Student updaStudent(Student student, Long id) {
        Optional<Student> studentExist = this.studentRepository.findById(id);

        if (!studentExist.isPresent()) {
            throw new StudentNotFoundException(String.format("student with id %s is not found"+ id));
        }

        return this.studentRepository.save(student);
    }

    public void removeStudent(Long id) {

        Optional<Student> studentExist = this.studentRepository.findById(id);

        if (!studentExist.isPresent()) {
            throw new StudentNotFoundException(String.format("student with id %s is not found", id));
        }

        this.studentRepository.delete(studentExist.get());
    }

}
