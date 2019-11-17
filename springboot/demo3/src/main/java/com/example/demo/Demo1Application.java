package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	
	
	
	@Component
	class EmployeeCommandLineRunner implements CommandLineRunner
	{
		@Autowired
		private EmployeeService employeeService;
		@SuppressWarnings("null")
		@Override
		public void run(String... args) throws Exception {
			Employee employee=null;
			employee=new Employee();
			employee.setFirstName("John");
			employee.setLastName("Doe");
			employee.setSalary(20000);
			employeeService.save(employee);
			employee.setFirstName("Sachin");
			employee.setLastName("Tendulkar");
			employee.setSalary(15000);
			employeeService.save(employee);
			employee.setFirstName("Rahul");
			employee.setLastName("Dravid");
			employee.setSalary(15000);
			employeeService.save(employee);
					
		}
	}
	 

}
