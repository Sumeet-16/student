package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
    //public Student findByGmail(String gmail);
//	public Student findByUserName(String username);

	

}
