package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Constants;
import com.backend.model.Projects;
import com.backend.model.Resume;
import com.backend.repository.ResumeRepo;

@Service
public class ProjectService {

	@Autowired
	private ResumeRepo repo;

	public String save(Projects projects,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProjects(projects);
		Resume result=repo.save(resume);
		if(result!=null)
		{
			return Constants.SUCCESS;
		}
		return Constants.FAILED;
	}
	
	public String update(Projects projects,HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setProjects(projects);
		Resume result=repo.save(resume);
		if(result!=null)
		{
			return Constants.SUCCESS;
		}
		return Constants.FAILED;
	}
	
	public Projects get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getProjects();
	}
}
