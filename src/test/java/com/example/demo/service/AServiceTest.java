package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ReflectionUtils;

import com.example.demo.service.impl.AServiceImpl;
import com.example.demo.service.impl.LogServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AServiceTest {

//	@Autowired
//	LogService logService;

//	@InjectMocks
//	private AServiceImpl aService;

	@Test
	public void temp() {

		AServiceImpl aServiceImpl = new AServiceImpl();

		assertNotNull(aServiceImpl.temp());

	}

	@Test
	public void temp2() {

		LogServiceImpl logService = new LogServiceImpl();

		AServiceImpl aServiceImpl = new AServiceImpl();

//        System.out.println(aServiceImpl.toString());

		// Get the logService field in the class
		Field logServiceField = ReflectionUtils.findField(AServiceImpl.class, "logService");
		ReflectionUtils.makeAccessible(logServiceField);

		// Set the value of the private field (e.g., setting a mock or real instance)
//        LogService logService = new LogServiceImpl(); // or use a mock instance
		ReflectionUtils.setField(logServiceField, aServiceImpl, logService);

		// Now you can call the method without encountering the NullPointerException
//        aServiceImpl.temp();

		assertNotNull(aServiceImpl.temp());

	}

}
