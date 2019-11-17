package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
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
	
	/*public Product(String name, String description, String detailsLink) {
		super();
		this.name = name;
		this.description = description;
		this.detailsLink = detailsLink;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailsLink() {
		return detailsLink;
	}

	public void setDetailsLink(String detailsLink) {
		this.detailsLink = detailsLink;
	}*/
	

}
