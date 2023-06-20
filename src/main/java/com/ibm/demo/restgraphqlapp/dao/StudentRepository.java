package com.ibm.demo.restgraphqlapp.dao;


import com.ibm.demo.restgraphqlapp.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}