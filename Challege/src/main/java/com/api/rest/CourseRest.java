package com.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.CourseDAO;
import com.api.model.Course;

//rest: the view create routes to request the server

@RestController
@RequestMapping("courses")


public class CourseRest {

	@Autowired
    private CourseDAO courseDAO;
	
	@PostMapping("/saveCourse") //localhost:8080/courses/saveCourse
	//Save data
	public void saveCourse(@RequestBody Course course) {
		courseDAO.save(course);
		
	}
	
	//list data
		@GetMapping("/toList") //localhost:8080/courses/toList
		
		public List<Course> toList(){
			
			return courseDAO.findAll();
			
		}
		
		//delete data
		
		@DeleteMapping("/deleteCourse/{code}")//localhost:8080/courses/delete/{code}
		public void deleteCourse(@PathVariable("code") Integer code) {
			courseDAO.deleteById(code);
		}
		
		//update
		@PutMapping("toUpdate")//localhost:8080/courses/toUpdate
		public void toUpdate(@RequestBody Course course) {
			courseDAO.save(course);
		}
		
		


	
	
}
