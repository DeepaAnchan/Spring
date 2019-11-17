package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		
		List<Employee> list = employeeService.findEmployees();
		model.addAttribute("listEmployees", list);
		return "employee-list";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") Integer theId, Model model) {
		
		Employee employee = employeeService.findEmployeeById(theId);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") Integer theId, Model model) {
		
		employeeService.deleteEmployee(theId);
		return "redirect:/employee/list";

		
	}

	
	@PostMapping("/save")
	public String employeeSave(@ModelAttribute("employee") @Valid Employee theEmployee,
		BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "employees/employee-form";
		}
		else {		
			// save the employee
			employeeService.saveEmployee(theEmployee);			
			// use a redirect to prevent duplicate submissions
			return "redirect:/employee/list";
		}
			
		
		
	}

}
