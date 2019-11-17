package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceRestController {
	
	@RequestMapping(value = "/getProductCategories", method = RequestMethod.GET)
    @ResponseBody
    public String getContact() {
        return "Product Categories";
    }


}