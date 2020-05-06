package com.backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Constants;
import com.backend.model.Projects;
import com.backend.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public ResponseEntity<?> saveProjects(@ModelAttribute Projects project,HttpServletRequest request)
	{	
		String result=projectService.save(project, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
		
	}

	@PutMapping("/project")
	public ResponseEntity<?> editProjects(@ModelAttribute Projects project,HttpServletRequest request)
	{	
		String result=projectService.update(project, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
		
	}
	
	@GetMapping("/project")
	public ResponseEntity<?> getProjects(HttpServletRequest request)
	{	
		Projects projects=projectService.get(request);
		return ResponseEntity.ok(projects);
		
	}
}
