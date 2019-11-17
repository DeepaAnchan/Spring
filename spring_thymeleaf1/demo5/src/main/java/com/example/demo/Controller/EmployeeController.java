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
		return "employees/employee-list";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") Integer theId, Model model) {
		
		Employee employee = employeeService.findEmployeeById(theId);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
		
	}
	
	@PostMapping("/delete")
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
	
	
	@GetMapping("/search")
	public String search(@RequestParam("firstName") String theFirstName,
						 @RequestParam("lastName") String theLastName,
						 Model theModel) {
		
		// check names, if both are empty then just give list of all employees
		if (theFirstName.trim().isEmpty() && theLastName.trim().isEmpty()) {
			return "redirect:/employee/list";
		}
		else {
			// else, search by first name and last name
			List<Employee> theEmployees = employeeService.searchBy(theFirstName, theLastName);
			
			// add to the spring model
			theModel.addAttribute("listEmployees", theEmployees);
			
			// send to list-employees
			return "employees/employee-list";
		}
		
	}

}
