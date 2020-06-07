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
import com.backend.model.Skills;
import com.backend.service.SkillService;

@RestController
@RequestMapping("/api")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@PostMapping("/skills")
	public ResponseEntity<?> saveSkills(@RequestBody Skills skills,HttpServletRequest request)
	{
		String result=skillService.save(skills, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/skills")
	public ResponseEntity<?> editSkills(@RequestBody Skills skills,HttpServletRequest request)
	{
		String result=skillService.update(skills, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/skills")
	public ResponseEntity<?> getSkills(HttpServletRequest request)
	{
		Skills skills=skillService.get(request);
		return ResponseEntity.ok(skills);
	}
}
