package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.service.AuthenticationService;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		String resumeId = service.login(email,password);
		System.out.println(resumeId);
		ModelMap map =new ModelMap();
		map.addAttribute("resumeId", resumeId);
		return ResponseEntity.ok(map);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody ModelMap map)
	{
		String result=service.register(map);
		return ResponseEntity.ok(result);
	}

}
