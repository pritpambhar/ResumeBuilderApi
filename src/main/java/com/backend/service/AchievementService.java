package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Achievements;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class AchievementService {
	
	@Autowired
	private ResumeRepo repo;
	
	public void save(Achievements achievements,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setAchievements(achievements);
		repo.save(resume);
	}
	
	public void update(Achievements achievements,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setAchievements(achievements);
		repo.save(resume);
	}
	
	public Achievements get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getAchievements();
	}

}
