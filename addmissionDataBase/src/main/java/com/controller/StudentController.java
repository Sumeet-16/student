package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.StudentNotFoundException;

import com.model.Student;
import com.repository.StudentRepo;
import com.service.StudentService;

import jakarta.validation.Valid;

@RestController

public class StudentController {
	
	@Autowired
	StudentRepo repository;
	
	@Autowired
	StudentService service;
	
	
	@GetMapping("/students")
	 public List<Student> allStudents() {

	        return repository.findAll();
	    }
	
	 @PostMapping("/addStudent")
	    public Student addStudent( @Valid @RequestBody Student student) throws StudentNotFoundException
	    {
	    	return service.addStudent(student);
	    }
	 
	 @PostMapping("/addStudents")
	    public List<Student> addStudent( @Valid @RequestBody List<Student> student ) throws StudentNotFoundException
	    {
	    	List<Student> s1=service.addStudents(student);
	    	return s1;
	    }

	 
	 @PutMapping("/updateStudent")
		public Student updateStudent( @Valid @RequestBody Student student) throws StudentNotFoundException
		{
			return service.updateStudent(student);
		}
	 
	 @DeleteMapping("/deletestudent/{id}")
		public Student deleteEmployee(@PathVariable int id) throws StudentNotFoundException
		{
			return service.deleteEmployee(id);
		}
	 
	  @GetMapping("/viewstudent/{id}")
		public Student viewDoctor(@PathVariable int id) throws  StudentNotFoundException
		{
			return service.viewStudentById(id);
		}
	  
	  
	  @PutMapping("/updateStudent/{id}") 
	  public Student updateStudentById( @Valid @PathVariable int id , @RequestBody Student student) throws  StudentNotFoundException
	  {
		  return service.updateStudentById(id,student);
	  }
	  
	  @GetMapping("/login")
	  public ResponseEntity<Object> login(@RequestParam String gmail, @RequestParam String pwd)  
	  {
		  try {
				Boolean user=service.login(gmail, pwd);
				return ResponseEntity.ok("User Logged In ..");

			} catch (StudentNotFoundException e) {

				return ResponseEntity.ok().body(e.getMessage());
			}
	  }


	 

}
