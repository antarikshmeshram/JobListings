package com.org.jobs.joblistings.controller;


import javax.servlet.http.HttpServletResponse;

import com.org.jobs.joblistings.model.Post;
import com.org.jobs.joblistings.repository.PostRepository;
import com.org.jobs.joblistings.repository.SearchRepository;
import com.org.jobs.joblistings.repository.SearchRepositoryImpl;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private SearchRepository searchRepository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchRepository.findByText(text);
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}
