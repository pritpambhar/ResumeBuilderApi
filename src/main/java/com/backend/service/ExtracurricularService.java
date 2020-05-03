package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Extracurriculars;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class ExtracurricularService {

	@Autowired
	private ResumeRepo repo;
	
	
	public void save(Extracurriculars extracurriculars,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setExtracurriculars(extracurriculars);
		repo.save(resume);
	}
	
	public void update(Extracurriculars extracurriculars,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setExtracurriculars(extracurriculars);
		repo.save(resume);
	}
	
	public Extracurriculars get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getExtracurriculars();
	}
}
