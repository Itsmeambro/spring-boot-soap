package com.ambro.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambro.soap.repository.StudentRepository;
import com.ambro.soap.xml.school.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student getStudent(String name) {
		
		List<com.ambro.soap.entity.Student> students = studentRepo.findByName(name);
		
		Student student = new Student();
		if(students.size()!=0) {
			
			com.ambro.soap.entity.Student studentObj = students.get(0);
			student.setName(studentObj.getName());
			student.setAddress(studentObj.getAddress());
			student.setStandard(studentObj.getStandard());
		}else {
			student.setName("Value not found");
			student.setAddress("");
			student.setStandard(0);
		}
		
		return student;
	}

}
