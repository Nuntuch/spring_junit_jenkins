package com.example.demo.service.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.LogService;


public abstract class BaseShareService {
	
	@Autowired
	public LogService logService;
	

}
