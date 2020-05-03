package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Projects;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@PostMapping("/project")
	public ResponseEntity<?> savePublicProfile(@ModelAttribute Projects project)
	{		 
		return ResponseEntity.ok("success");
	}

}
