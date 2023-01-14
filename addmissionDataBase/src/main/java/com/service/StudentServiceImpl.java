package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.StudentNotFoundException;

import com.model.Student;
import com.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo repository;
	
	

	@Override
	public Student addStudent(Student student) throws StudentNotFoundException {
		List<Student> students=this.viewAllStudents();
		for(Student dc:students)
		{
			if(dc.getUsername().equals(student.getUsername()) || dc.getGmail().equals(student.getGmail()))
			{
				throw new StudentNotFoundException("user already exist");
			}
		}
		 return repository.saveAndFlush(student);
	}

	@Override
	public List<Student> viewAllStudents() {

		return repository.findAll();
	}

	@Override
	public Student updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> result=repository.findById(student.getId());
		if(result.isPresent())
		{
			return repository.saveAndFlush(student);
		}
		else
		{
			throw new StudentNotFoundException("please enter valid  id");
		}
	}

	@Override
	public Student deleteEmployee(int id) throws StudentNotFoundException {
		Optional<Student> result=repository.findById(id);
		if(result.isPresent())
		{
			repository.deleteById(id);
			return result.get();
		}
		else
		{
			throw new StudentNotFoundException("there is no record found in our database");
		}
	}

	@Override
	public Student viewStudentById(int id) throws StudentNotFoundException {
		java.util.Optional<Student> result = repository.findById(id); 
		if(result.isPresent()) {
			repository.findById(id);
			return result.get();
		}
		else {
			throw new StudentNotFoundException("there is no Records found in our database");
		}
	}

	@Override
	public Student updateStudentById(int id, Student student) throws StudentNotFoundException {
		if(repository.findById(id).isPresent())
		{
			Student s1=repository.findById(id).get();
		s1.setName(student.getName());
			s1.setGmail(student.getGmail());
			s1.setMobileno(student.getMobileno());
			s1.setPwd(student.getPwd());
			s1.setRepwd(student.getRepwd());
			s1.setUsername(student.getUsername());
			
			Student s2=repository.save(s1);
		return s2;
			
		}
	
	else
	{
		throw new StudentNotFoundException("not found");
	}
	}


	@Override
	public List<Student> addStudents(List<Student> student) throws StudentNotFoundException  {
//		List<Student> students=this.viewAllStudents();
//		
//		for(Student dc:students)
//		{
//			if(dc.getUsername().equals(s2.getUsername()) || dc.getGmail().equals(s2.getGmail()))
//			{
//				throw new StudentNotFoundException("user already exist");
//			}
//		
			
		
	//}
		List<Student> lc1=repository.saveAll(student);
		return lc1;
	
	
}
}