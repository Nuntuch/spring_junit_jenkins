package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class UnitTestTestService {

	@InjectMocks
	private TestService testService;
	
	@Test
	public void test() {
//		fail("Not yet implemented");
		
		assertEquals(testService.addNum(1,1), 2);
	}

}
