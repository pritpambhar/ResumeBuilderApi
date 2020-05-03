package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Education;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class EducationService {
	@Autowired
	private ResumeRepo repo;
	
	public void save(Education education,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setEducation(education);
		repo.save(resume);
	}
	
	public void update(Education education,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setEducation(education);
		repo.save(resume);
	}
	
	public Education get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getEducation();
	}

}
