package com.backend.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.backend.model.Resume;
import com.backend.model.User;
import com.backend.repository.ResumeRepo;
import com.backend.repository.UserRepo;

@Service
public class AuthenticationService {

	@Autowired
	private ResumeRepo repo;
	@Autowired
	private UserRepo userrepo;
	
	public String login(String email,String password)
	{
		User user=userrepo.findByEmail(email);
		return user.getResumeId();
	}
	
	public String register(ModelMap map)
	{
			String id=ObjectId.get().toString();
			Resume resume = new Resume();
			resume.setId(id);
			repo.save(resume);
			
			User user=new User();
			user.setId(ObjectId.get().toString());
			user.setEmail(map.getAttribute("email").toString());
			user.setPassword(map.getAttribute("password").toString());
			user.setResumeId(id);
			userrepo.save(user);
			return "registered successfully";
	}
}
