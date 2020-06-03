package com.api.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.StudentDAO;
import com.api.model.Student;



@RestController
@RequestMapping("students")


public class StudentRest {
	Student objStudent = new Student();

	@Autowired
    private StudentDAO studentDAO;
	
	//@PostMapping("/saveStudent") //localhost:8080/students/saveStudent
	//Save data
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)

	public  void saveStudent(@RequestBody Student student,HttpServletResponse response) {
		String[] dvUser= student.getRut().split("-");
		String dv = objStudent.dv(dvUser[0]);
		
		if(dv.contains(dvUser[1])) {
			studentDAO.save(student);
		
		}else {
			response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
		}
		
		
	}
	
	//list data
		//@GetMapping("/toListStudent") //localhost:8080/courses/toList
	
	@RequestMapping(value="/toListStudent",method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
		
		public @ResponseBody List<Student> toListStudent(){
			
				return studentDAO.findAll();
		
		}
		
		//delete data
		
		@DeleteMapping("/deleteStudent/{code}")//localhost:8080/courses/delete/{code}
		public void deleteStudent(@PathVariable("code") String code,HttpServletResponse response) {
			try {
				studentDAO.deleteById(code);
			}catch(Exception ex) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
			
		}
		
		//update
		@PutMapping("toUpdate")//localhost:8080/courses/toUpdate
		public void toUpdate(@RequestBody Student student) {
			studentDAO.save(student);
		}
		
		


	
	
}
