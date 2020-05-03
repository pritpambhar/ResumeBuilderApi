package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Internships;

@RestController
@RequestMapping("/api")
public class InternshipController {

	@PostMapping("/internships")
	public ResponseEntity<?> saveInternships(@ModelAttribute Internships internships)
	{
		return ResponseEntity.ok("success");
	}
}
