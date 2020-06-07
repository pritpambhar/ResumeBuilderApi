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
import com.backend.model.Extracurriculars;
import com.backend.service.ExtracurricularService;

@RestController
@RequestMapping("/api")
public class ExtraCurricularController {
	
	@Autowired
	private ExtracurricularService extracurricularService;
	
	@PostMapping("/extracurriculars")
	public ResponseEntity<?> saveExtraCurricular(@RequestBody Extracurriculars extracurriculars,HttpServletRequest request)
	{
		String result=extracurricularService.save(extracurriculars,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/extracurriculars")
	public ResponseEntity<?> editExtraCurricular(@RequestBody Extracurriculars extracurriculars,HttpServletRequest request)
	{
		String result=extracurricularService.update(extracurriculars,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/extracurriculars")
	public ResponseEntity<?> getExtraCurricular(HttpServletRequest request)
	{
		Extracurriculars extracurriculars=extracurricularService.get(request);
		return ResponseEntity.ok(extracurriculars);
	}
}
