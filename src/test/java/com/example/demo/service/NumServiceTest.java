package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class NumServiceTest {

	@InjectMocks
	private NumService numService;
	
	@Test
	public void addNum() {

		assertEquals(numService.addNum(1,1), 2);
	}

}
