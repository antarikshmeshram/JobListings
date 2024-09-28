package com.org.jobs.joblistings.repository;

import com.org.jobs.joblistings.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
