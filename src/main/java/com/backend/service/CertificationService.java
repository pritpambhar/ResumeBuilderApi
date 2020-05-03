package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Certifications;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class CertificationService {

	@Autowired
	private ResumeRepo repo;
	
	
	public void save(Certifications certifications,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setCertifications(certifications);
		repo.save(resume);
	}
	
	public void update(Certifications certifications,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setCertifications(certifications);
		repo.save(resume);
	}
	
	public Certifications get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getCertifications();
	}
}
