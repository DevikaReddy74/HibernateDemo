package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
