package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.RabbitMQSender;
import com.example.demo.entity.Employee;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	

	@PostMapping(value = "/save")
	public String employeeSave(@ModelAttribute("employee") @Valid Employee theEmployee) {
	
		rabbitMQSender.send(theEmployee);
		System.out.println("Message SENT");
		return "redirect:/employee/list";
	}
	
	
	
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		
		return "employees/employee-list";
		
	}
	
	

}
