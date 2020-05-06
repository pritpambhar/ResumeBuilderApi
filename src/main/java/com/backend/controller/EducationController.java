package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Constants;
import com.backend.model.Education;
import com.backend.model.Graduation;
import com.backend.model.HigherSecondary;
import com.backend.model.Secondary;
import com.backend.service.EducationService;

@RestController
@RequestMapping("/api")
public class EducationController {

	@Autowired
	private EducationService educationService;
	
	@PostMapping("/education")
	public ResponseEntity<?> saveEducationDetail(ModelMap map,HttpServletRequest request)
	{
		map.addAttribute("secondary", new Secondary());
		map.addAttribute("higherSecondary", new HigherSecondary());
		map.addAttribute("graduation", new Graduation());
		String result=educationService.save(map, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/education")
	public ResponseEntity<?> editEducationDetail(ModelMap map,HttpServletRequest request)
	{
		map.addAttribute("secondary", new Secondary());
		map.addAttribute("higherSecondary", new HigherSecondary());
		map.addAttribute("graduation", new Graduation());
		String result=educationService.update(map, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/education")
	public ResponseEntity<?> getEducationDetail(HttpServletRequest request)
	{
		Education education=educationService.get(request);
			return ResponseEntity.ok(education);
	}
}
