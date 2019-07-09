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
	
	
	@GetMapping("/data")
	public List<Student> retriveAllData(@RequestParam(name="filter", defaultValue="") String fieldName) {
		return studentService.retrieveDataStudent(fieldName);
	}
	
	@GetMapping("/statistics")
	public HashMap<String,Double> retrieveStatistics(@RequestParam(name="field", defaultValue="") String param,
	@RequestParam(name="filter", defaultValue="") String filter) {
		return studentService.retrieveStatistics(param,filter);
	}
	
	@GetMapping("/metadata")
	public List<Attribute> retrieveData() {
		return studentService.retrieveDataAttribute();
	}
}
