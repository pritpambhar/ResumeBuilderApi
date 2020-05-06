package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Constants;
import com.backend.model.Internships;
import com.backend.service.InternshipService;

@RestController
@RequestMapping("/api")
public class InternshipController {
	
	@Autowired
	private InternshipService internshipService;

	@PostMapping("/internships")
	public ResponseEntity<?> saveInternships(@ModelAttribute Internships internships,HttpServletRequest request)
	{	
		String result=internshipService.save(internships, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PostMapping("/internships")
	public ResponseEntity<?> editInternships(@ModelAttribute Internships internships,HttpServletRequest request)
	{	
		String result=internshipService.update(internships, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/internships")
	public ResponseEntity<?> getInternships(@ModelAttribute Internships internships,HttpServletRequest request)
	{	
		Internships internship=internshipService.get(request);
			return ResponseEntity.ok(internship);
	}
}
