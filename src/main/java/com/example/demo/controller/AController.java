package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {
	
//	@Autowired
//	private 
	
	@GetMapping("/inquiry/data/a")
	public String inquiryDataA() {
		
		
		return "a";
	}

}
