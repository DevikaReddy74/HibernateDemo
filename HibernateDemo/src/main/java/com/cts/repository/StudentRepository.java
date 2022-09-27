package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
