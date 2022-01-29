package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	@Query(value = "select * from student where name=cast(:name AS text)", nativeQuery = true)
	Student getReport(@Param("name") String name);
	
	@Query(value = "select * from student where roll_no=cast(:rollno AS integer)", nativeQuery = true)
	Student getReportByRollNo(@Param("rollno") String roll_no);

	@Query(value = "select * from student where ranks=1", nativeQuery = true)
	List<Student> getRank();
	
	
 }
