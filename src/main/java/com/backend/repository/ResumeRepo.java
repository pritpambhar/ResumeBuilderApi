package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Resume;

@Repository
public interface ResumeRepo extends MongoRepository<Resume, String>{
}
