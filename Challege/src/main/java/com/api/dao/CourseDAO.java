package com.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.model.Course;


//DAO logic or controller

public interface CourseDAO extends JpaRepository<Course, Integer>{

}