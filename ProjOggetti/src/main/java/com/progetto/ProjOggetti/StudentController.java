package com.progetto.ProjOggetti;

import java.net.URI;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/data/")
	public List<Student> retriveAllData(@RequestParam(filter="fieldName", defaultValue="") String fieldName) {
		return studentService.retrieveDataStudent(fieldName);
	}
	
	@GetMapping("/data/filter/{filter}")
	public List<Student> retriveAllData(@RequestParam(filter="fieldName", defaultValue="") String fieldName) {
		return studentService.retrieveDataStudent(fieldName);
	}
	
	@GetMapping("/statistics/")
	public HashMap<String,Double> retrieveStatistics(@RequestParam String param) {
		return studentService.retrieveStatistics(param);
	}
	
	@GetMapping("/students/{studentId}/courses")
	public List<Course> retrieveCoursesForStudent(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}

	@PostMapping("/students/{studentId}/courses")
	public ResponseEntity<Void> registerStudentForCourse(
			@PathVariable String studentId, @RequestBody Course newCourse) {

		Course course = studentService.addCourse(studentId, newCourse);

		if (course == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(course.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable String studentId,
			@PathVariable String courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}

}
