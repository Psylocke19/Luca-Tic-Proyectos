package com.proyecto.spring;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.proyecto.spring.control.Control;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Proyecto2ApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(Proyecto2ApplicationTests.class);
	
	@Test
	public void contextLoads() {
	}

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info("@BeforeClass: Al inicio de las pruebas");
	}
}
