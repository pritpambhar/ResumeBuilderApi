package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Internships;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class InternshipService {

	@Autowired
	private ResumeRepo repo;
	
	public void save(Internships internships,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setInternships(internships);
		repo.save(resume);
	}
	
	public void update(Internships internships,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setInternships(internships);
		repo.save(resume);
	}
	
	public Internships get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getInternships();
	}
}
