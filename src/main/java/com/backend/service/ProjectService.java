package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Projects;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class ProjectService {

	@Autowired
	private ResumeRepo repo;

	public void save(Projects projects,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProjects(projects);
		repo.save(resume);
	}
	
	public void update(Projects projects,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProjects(projects);
		repo.save(resume);
	}
	
	public Projects get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getProjects();
	}
}
