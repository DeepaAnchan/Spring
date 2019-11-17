package com.mynotes.spring.cloud.service;

public class Offers {
	private Long Id;

	private String title;
	
	private String description;
	
	private String detailsLink;
	
	
	@Override
	public String toString() {
		return "Offers [Id=" + Id + ", title=" + title + ", description=" + description + ", detailsLink=" + detailsLink
				+ "]";
	}

	public Offers() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	

}