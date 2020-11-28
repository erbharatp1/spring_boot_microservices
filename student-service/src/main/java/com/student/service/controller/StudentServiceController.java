package com.student.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.service.model.Student;
/**
 * 
 * @author Bharat
 *
 */
@RestController
public class StudentServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentServiceController.class);

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();

	static {
		schooDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Bharat", "Class IV");
		lst.add(std);
		std = new Student("Rishi", "Class V");
		lst.add(std);

		schooDB.put("davSchool", lst);

		lst = new ArrayList<Student>();
		std = new Student("Sanchita", "Class III");
		lst.add(std);
		std = new Student("Raazveer", "Class VI");
		lst.add(std);

		schooDB.put("gyanveerSchool", lst);

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		log.info("Getting Student details for " + schoolname);

		List<Student> studentList = schooDB.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}