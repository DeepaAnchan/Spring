package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PostRepository;
import com.example.demo.model.Posts;

@Service
public class PostServiceImpl implements PostService {
@Autowired
	private PostRepository postRepository;
	
	@Override
	public List<Posts> getAllPosts() {
		// TODO Auto-generated method stub
		return postRepository.findAll();
	}

}
