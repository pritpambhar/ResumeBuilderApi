package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Positions;

@RestController
@RequestMapping("/api")
public class PositonController {

	@PostMapping("/positions")
	public ResponseEntity<?> savePositions(@ModelAttribute Positions positions)
	{
		return ResponseEntity.ok("success");
	}
}
