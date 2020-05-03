package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeclarationController {

	@PostMapping("/declaration")
	public ResponseEntity<?> saveDeclaration(@RequestParam String objective)
	{
		return ResponseEntity.ok("success");
	}
}
