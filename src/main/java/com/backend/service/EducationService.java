package com.backend.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.backend.model.Constants;
import com.backend.model.Education;
import com.backend.model.Graduation;
import com.backend.model.HigherSecondary;
import com.backend.model.Resume;
import com.backend.model.Secondary;
import com.backend.repository.ResumeRepo;

@Service
public class EducationService {
	@Autowired
	private ResumeRepo repo;
	
	public String save(ModelMap map,HttpServletRequest request)
	{
		Secondary secondary=(Secondary) map.getAttribute("secondary");
		HigherSecondary highSecondary= (HigherSecondary) map.getAttribute("higherSecondary");
		Graduation graduation =(Graduation)map.getAttribute("graduation");
		Education education=new Education(secondary,highSecondary,graduation);
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setEducation(education);
		Resume result=repo.save(resume);
		if(result!=null)
		{
			return Constants.SUCCESS;
		}
		return Constants.FAILED;
	}
	
	public String update(ModelMap map,HttpServletRequest request)
	{	
		Secondary secondary=(Secondary) map.getAttribute("secondary");
		HigherSecondary highSecondary= (HigherSecondary)map.getAttribute("higherSecondary");
		Graduation graduation =(Graduation)map.getAttribute("graduation");
		Education education1=new Education(secondary,highSecondary,graduation);
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		resume.setEducation(education1);
		Resume result=repo.save(resume);
		if(result!=null)
		{
			return Constants.SUCCESS;
		}
		return Constants.FAILED;
	}
	
	public Education get(HttpServletRequest request)
	{
		String id=request.getHeader("token");
		Optional<Resume> r=repo.findById(id);
		Resume resume=r.get();
		return resume.getEducation();
	}

}
