package com.example.demo.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Posts {
	private String name;
	private ObjectId _id;
	
	public String get_id() {
		return _id.toHexString();
	}

}
