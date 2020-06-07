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
import com.backend.model.GeneralInfo;
import com.backend.service.GeneralInfoService;

@RestController
@RequestMapping("/api")
//@CrossOrigin
public class GeneralInfoController {
	
	@Autowired
	private GeneralInfoService generalInfoService;
	
	@PostMapping("/generalinfo")
	public ResponseEntity<?> saveGeneralInfo(@RequestBody GeneralInfo generalInfo,HttpServletRequest request)
	{
		String result = generalInfoService.save(generalInfo,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/generalinfo")
	public ResponseEntity<?> editGeneralInfo(@RequestBody GeneralInfo generalInfo,HttpServletRequest request)
	{
		String result = generalInfoService.update(generalInfo,request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/generalinfo")
	public ResponseEntity<?> getGeneralInfo(HttpServletRequest request)
	{
		GeneralInfo generalInfo = generalInfoService.get(request);
		return ResponseEntity.ok(generalInfo);
	}
}
