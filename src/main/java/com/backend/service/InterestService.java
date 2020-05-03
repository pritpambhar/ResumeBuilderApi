package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Interests;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class InterestService {

	@Autowired
	private ResumeRepo repo;
	
	public void save(Interests interests,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setInterests(interests);
		repo.save(resume);
	}
	
	public void update(Interests interests,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setInterests(interests);
		repo.save(resume);
	}
	
	public Interests get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getInterests();
	}
}
