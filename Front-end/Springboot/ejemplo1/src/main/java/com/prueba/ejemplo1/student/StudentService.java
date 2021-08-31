package com.prueba.ejemplo1.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents(){
		return List.of(new Student(1L, "Nelson",21,LocalDate.of(1998, 8, 6),"NElson@gmail.com"));
	}
}
