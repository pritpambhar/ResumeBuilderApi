package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Skills;

@RestController
@RequestMapping("/api")
public class SkillController {

	@PostMapping("/skills")
	public ResponseEntity<?> saveSkills(@ModelAttribute Skills skills)
	{
		return ResponseEntity.ok("success");
	}
}
