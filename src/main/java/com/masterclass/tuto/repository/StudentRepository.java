package com.masterclass.tuto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masterclass.tuto.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
