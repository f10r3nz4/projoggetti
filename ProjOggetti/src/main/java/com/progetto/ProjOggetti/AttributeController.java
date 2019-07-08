package com.progetto.ProjOggetti;

import java.net.URI;
import java.util.List;

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
public class AttributeController {
	
	@Autowired
	private StudentService studentService;
	//Richiama il metodo per restituire i metadati in formato json in base ai parametri definiti in Attribute
	@GetMapping("/metadata/")
	public List<Attribute> retrieveData() {
		return studentService.retrieveDataAttribute();
	}
}
