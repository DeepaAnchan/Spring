package com.example.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PostService;
import com.example.demo.model.Posts;

@RestController
@RequestMapping("/api")
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	@GetMapping("/posts")
	public List<Posts> getAllPosts(){
		return postService.getAllPosts();
	}

}