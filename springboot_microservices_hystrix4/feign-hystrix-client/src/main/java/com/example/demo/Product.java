package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="Product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
	private ObjectId _id;
	private String name;
	
	private String description;
	
	private String detailsLink;
	@SuppressWarnings("unused")
	private String get_id() {
		return _id.toHexString();
	}
	
	

}
