package com.org.jobs.joblistings.repository;

import com.org.jobs.joblistings.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
