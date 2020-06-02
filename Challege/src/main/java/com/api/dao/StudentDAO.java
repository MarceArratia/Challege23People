package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.model.Student;


//DAO logic or controller student

public interface StudentDAO extends JpaRepository<Student, String>{

}