package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Achievements;
import com.backend.model.Constants;
import com.backend.model.GeneralInfo;
import com.backend.service.AchievementService;

@RestController
@RequestMapping("/api")
public class AchievementController {
	
	@Autowired
	private AchievementService achievementService;
	
	@PostMapping("/achievements")
	public ResponseEntity<?> saveAchievements(@RequestBody Achievements achievements,HttpServletRequest request)
	{
		String result=achievementService.save(achievements, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/achievements")
	public ResponseEntity<?> editAchievements(@RequestBody Achievements achievements,HttpServletRequest request)
	{
		String result=achievementService.update(achievements, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/achievements")
	public ResponseEntity<?> getAchievements(HttpServletRequest request)
	{
		Achievements achievements = achievementService.get(request);
		return ResponseEntity.ok(achievements);
	}
}
