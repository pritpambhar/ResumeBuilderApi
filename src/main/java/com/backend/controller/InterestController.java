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

import com.backend.model.Constants;
import com.backend.model.Interests;
import com.backend.service.InterestService;

@RestController
@RequestMapping("/api")
public class InterestController {
	
	@Autowired
	private InterestService interestService;
	
	@PostMapping("/interests")
	public ResponseEntity<?> saveInterests(@RequestBody Interests interests,HttpServletRequest request)
	{
		String result=interestService.save(interests,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/interests")
	public ResponseEntity<?> editInterests(@RequestBody Interests interests,HttpServletRequest request)
	{
		String result=interestService.update(interests,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/interests")
	public ResponseEntity<?> getInterests(HttpServletRequest request)
	{
		Interests interests=interestService.get(request);
			return ResponseEntity.ok(interests);
	}
}
