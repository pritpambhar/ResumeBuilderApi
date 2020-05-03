package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.PublicProfile;
import com.backend.service.PublicProfileService;

@RestController
@RequestMapping("/api")
public class PublicProfileController {
	
	@Autowired
	private PublicProfileService publicProfileService; 
	
	@PostMapping("/publicprofile")
	public ResponseEntity<?> savePublicProfile(@RequestParam("website") String website,@RequestParam("github") String github,@RequestParam("linkdin") String linkdin,HttpServletRequest request)
	{
		PublicProfile profile=new PublicProfile(website, github, linkdin);
		publicProfileService.save(profile,request);
		return ResponseEntity.ok("success");
	}
	
	@PutMapping("/publicprofile")
	public ResponseEntity<?> updatePublicProfile(@RequestParam("website") String website,@RequestParam("github") String github,@RequestParam("linkdin") String linkdin,HttpServletRequest request)
	{
		PublicProfile profile=new PublicProfile(website, github, linkdin);
		publicProfileService.update(profile,request);
		return ResponseEntity.ok("success");
	}
	
	@GetMapping("/publicprofile")
	public ResponseEntity<?> getPublicProfile(HttpServletRequest request)
	{
		publicProfileService.get(request);
		return ResponseEntity.ok("success");
	}
}
