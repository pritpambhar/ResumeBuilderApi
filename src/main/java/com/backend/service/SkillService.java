package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Resume;
import com.backend.model.Skills;
import com.backend.repository.ResumeRepo;

@Service
public class SkillService {

	@Autowired
	private ResumeRepo repo;
	
	public void save(Skills skills,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setSkills(skills);
		repo.save(resume);
	}
	
	public void update(Skills skills,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setSkills(skills);
		repo.save(resume);
	}
	
	public Skills get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getSkills();
	}
}
