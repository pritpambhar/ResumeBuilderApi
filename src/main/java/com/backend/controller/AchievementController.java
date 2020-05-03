package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Achievements;

@RestController
@RequestMapping("/api")
public class AchievementController {
	
	@PostMapping("/achievements")
	public ResponseEntity<?> saveAchievements(@ModelAttribute Achievements achievements,HttpServletRequest request)
	{
		return ResponseEntity.ok("success");
	}
}
