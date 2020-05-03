package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Extracurriculars;
import com.backend.service.ExtracurricularService;

@RestController
@RequestMapping("/api")
public class ExtraCurricularController {
	
	@Autowired
	private ExtracurricularService extracurricularService;
	
	@PostMapping("/extracurriculars")
	public ResponseEntity<?> saveExtraCurricular(@ModelAttribute Extracurriculars extracurriculars,HttpServletRequest request)
	{
		extracurricularService.save(extracurriculars,request);
		return ResponseEntity.ok("success");
	}
}
