package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.LogService;

@Service
public class LogServiceImpl implements LogService{

	@Override	
	public void printLog(String content) {
		
		System.out.println(content);
		
	}


}
