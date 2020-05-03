package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.PublicProfile;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class PublicProfileService {
	@Autowired
	private ResumeRepo repo;
	
	public void save(PublicProfile profile,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProfile(profile);
		repo.save(resume);
	}
	
	public void update(PublicProfile profile,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProfile(profile);
		repo.save(resume);
	}
	
	public PublicProfile get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getProfile();
	}
}
