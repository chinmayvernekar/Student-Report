package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	// Get All The Students Record In Database
	public List<Student> getAllRecords() {
		return (List<Student>) studentRepo.findAll();
	}

	// Get Peresonalised Report of Every Student by Name
	public Student getPersonalisedReport(String name) {
		return studentRepo.getReport(name);
	}

	// Get Peresonalised Report of Every Student by Name
	public Student getPersonalisedReportByRollNo(String roll_no) {
		return studentRepo.getReportByRollNo(roll_no);
	}
	
	//Get First 3 Rank
	public List<Student> getRanksOfStudent() {
		return studentRepo.getRank();
	}
	
	
}
