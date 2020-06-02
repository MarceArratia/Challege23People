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
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.StudentDAO;
import com.api.model.Student;



@RestController
@RequestMapping("students")


public class StudentRest {

	@Autowired
    private StudentDAO studentDAO;
	
	@PostMapping("/saveStudent") //localhost:8080/students/saveStudent
	//Save data
	public void saveStudent(@RequestBody Student student) {
		studentDAO.save(student);
		
	}
	
	//list data
		@GetMapping("/toListStudent") //localhost:8080/courses/toList
		
		public List<Student> toListStudent(){
			
			return studentDAO.findAll();
			
		}
		
		//delete data
		
		@DeleteMapping("/deleteStudent/{code}")//localhost:8080/courses/delete/{code}
		public void deleteStudent(@PathVariable("code") String code) {
			studentDAO.deleteById(code);
		}
		
		//update
		@PutMapping("toUpdate")//localhost:8080/courses/toUpdate
		public void toUpdate(@RequestBody Student student) {
			studentDAO.save(student);
		}
		
		


	
	
}