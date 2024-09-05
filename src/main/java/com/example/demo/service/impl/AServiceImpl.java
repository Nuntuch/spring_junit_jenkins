package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.AService;
import com.example.demo.service.base.BaseShareService;

@Service
public class AServiceImpl extends BaseShareService implements AService{

	public String temp() {
		
		logService.printLog("A Service Temp");
		
		return "A Service Temp";
		
	}
	
	
}
