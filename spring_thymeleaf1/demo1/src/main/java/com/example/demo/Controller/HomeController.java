package com.example.demo.Controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/displayDate")
	public String displayDate(Model model) {
		
		model.addAttribute("theDate", new Date());
		return "helloWorld";
		
	}

}
