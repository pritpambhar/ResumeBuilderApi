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
import com.backend.model.Positions;
import com.backend.service.PositionService;

@RestController
@RequestMapping("/api")
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	@PostMapping("/positions")
	public ResponseEntity<?> savePositions(@RequestBody Positions positions,HttpServletRequest request)
	{
		String result=positionService.save(positions, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@PutMapping("/positions")
	public ResponseEntity<?> editPositions(@RequestBody Positions positions,HttpServletRequest request)
	{
		String result=positionService.update(positions, request);
		if(result.equals(Constants.SUCCESS))
		{
			return ResponseEntity.ok(Constants.SUCCESS);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.FAILED);
	}
	
	@GetMapping("/positions")
	public ResponseEntity<?> getPositions(HttpServletRequest request)
	{
		Positions positions=positionService.get(request);
		return ResponseEntity.ok(positions);
		
	}
}
