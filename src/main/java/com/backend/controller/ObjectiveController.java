package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Constants;

@RestController
@RequestMapping("/api")
public class ObjectiveController {

	@PostMapping("/objective")
	public ResponseEntity<?> saveObjective(@RequestParam String objective)
	{	
		return ResponseEntity.ok(Constants.SUCCESS);
	}
}
