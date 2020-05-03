package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Interests;
import com.backend.service.InterestService;

@RestController
@RequestMapping("/api")
public class InterestController {
	
	@Autowired
	private InterestService interestService;
	
	@PostMapping("/interests")
	public ResponseEntity<?> saveInterests(@ModelAttribute Interests interests,HttpServletRequest request)
	{
		interestService.save(interests,request);
		return ResponseEntity.ok("success");
	}
}
