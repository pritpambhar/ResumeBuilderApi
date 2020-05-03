package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.model.User;

public interface UserRepo extends MongoRepository<User, String> {

	public User findByEmail(String email);
}
