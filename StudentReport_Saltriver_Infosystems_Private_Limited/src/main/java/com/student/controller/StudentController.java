package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping(value = "/students/reports")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Student> allRecords() {
		return studentService.getAllRecords();
	}

	@RequestMapping(value = "byName/{name}", method = RequestMethod.GET)
	public Student report(@PathVariable("name") String name) {
		return studentService.getPersonalisedReport(name);
	}

	@RequestMapping(value = "byRollNo/{rollno}", method = RequestMethod.GET)
	@ResponseBody
	public Student reportByRollNo(@PathVariable("rollno") String roll_no) {
		return studentService.getPersonalisedReportByRollNo(roll_no);
	}

	@RequestMapping(value = "ranks", method = RequestMethod.GET)
	public List<Student> ranksOfStudent() {
		return studentService.getRanksOfStudent();
	}

	
}
