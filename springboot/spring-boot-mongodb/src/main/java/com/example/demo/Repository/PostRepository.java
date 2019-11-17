package com.example.demo.Repository;

import org.springframework.stereotype.Repository;
import com.example.demo.model.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;


@Repository
public interface PostRepository  extends MongoRepository<Posts,String>{

}
