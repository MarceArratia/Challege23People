package com.api.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public void saveCourse(@RequestBody Course course,HttpServletResponse response) {
		try {
			
		courseDAO.save(course);
		response.setStatus(HttpServletResponse.SC_CREATED);
		}
		catch(Exception ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}
	
	//list data
		//@GetMapping("/all") //localhost:8080/courses/toList
		@RequestMapping(value="/all",method=RequestMethod.GET)
		public List<Course> all(){
			
			return courseDAO.findAll();
			
		}
		@GetMapping("/id/{code}")
		public Optional<Course> id(@PathVariable("code") Integer code,HttpServletResponse response){
			
			Optional<Course> list = courseDAO.findById(code);
			 if(list !=null) {
				 response.setStatus(HttpServletResponse.SC_OK);
				 return list;
			 }
			 else
			 { 
				 response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				 return null;
			 }
		}
		@GetMapping("/page")
		public Page<Course> page(){
			
			Pageable paging = PageRequest.of(10,10);
			Page<Course> list = courseDAO.findAll(paging);
			 
	        return list;
		}
		//delete data
		
		@DeleteMapping("/deleteCourse/{code}")//localhost:8080/courses/delete/{code}
		public void deleteCourse(@PathVariable("code") Integer code,HttpServletResponse response) {
			try
			{
				courseDAO.deleteById(code);
				 response.setStatus(HttpServletResponse.SC_OK);
			}
			catch(Exception ex) {
				 response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		}
		
		//update
		@PutMapping("toUpdate")//localhost:8080/courses/toUpdate
		public void toUpdate(@RequestBody Course course) {
			courseDAO.save(course);
		}
		
		


	
	
}
