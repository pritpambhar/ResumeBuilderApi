package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Positions;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class PositionService {

	@Autowired
	private ResumeRepo repo;
	
	public void save(Positions positions,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setPositions(positions);
		repo.save(resume);
	}
	
	public void update(Positions positions,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setPositions(positions);
		repo.save(resume);
	}
	
	public Positions get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getPositions();
	}
}
