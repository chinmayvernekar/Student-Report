package com.student.config;

import org.springframework.batch.item.ItemProcessor;

import com.student.model.Student;

public class ItemProcess implements ItemProcessor<Student, Student> {

	@Override
	public Student process(Student student) throws Exception {

		return student;
	}

}
