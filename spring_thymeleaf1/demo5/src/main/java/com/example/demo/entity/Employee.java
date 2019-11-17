package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer id;
	
	@NotBlank(message="is required")
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank(message="is required")
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank(message="is required")
	@Column(name = "email")
	private String email;	

}
