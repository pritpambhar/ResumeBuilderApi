package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Graduation;
import com.backend.model.HigherSecondary;
import com.backend.model.Secondary;

@RestController
@RequestMapping("/api")
public class EducationController {

	@PostMapping("/education")
	public ResponseEntity<?> saveEducationDetail(ModelMap map)
	{
		map.addAttribute("secondary", new Secondary());
		map.addAttribute("higherSecondary", new HigherSecondary());
		map.addAttribute("graduation", new Graduation());
		return ResponseEntity.ok("success");
	}
}
