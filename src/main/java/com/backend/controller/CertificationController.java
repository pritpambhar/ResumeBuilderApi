package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Achievements;
import com.backend.model.Certifications;
import com.backend.model.Constants;
import com.backend.service.AchievementService;
import com.backend.service.CertificationService;

@RestController
@RequestMapping("/api")
public class CertificationController {
	
	@Autowired
	private CertificationService certificationService;
	
	@PostMapping("/certifications")
	public ResponseEntity<?> saveCertifications(@ModelAttribute Certifications certifications,HttpServletRequest request)
	{
		String result=certificationService.save(certifications, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/certifications")
	public ResponseEntity<?> editAchievements(@ModelAttribute Certifications certifications,HttpServletRequest request)
	{
		String result=certificationService.update(certifications, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/certifications")
	public ResponseEntity<?> getAchievements(HttpServletRequest request)
	{
		Certifications certifications = certificationService.get(request);
		return ResponseEntity.ok(certifications);
	}
}
