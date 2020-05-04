package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Certifications;

@RestController
@RequestMapping("/api")
public class CertificationController {
	
	@PostMapping("/certifications")
	public ResponseEntity<?> saveCertifications(@ModelAttribute Certifications certifications)
	{
		return ResponseEntity.ok("success");
	}
	
}
