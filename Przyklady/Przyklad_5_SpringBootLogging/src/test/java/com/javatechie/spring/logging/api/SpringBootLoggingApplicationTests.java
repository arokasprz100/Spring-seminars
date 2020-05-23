package com.javatechie.spring.logging.api;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLoggingApplicationTests {

	@Test
	public void validNameTest() {
		SpringBootLoggingApplication springBootLoggingApplication = new SpringBootLoggingApplication();
        String result = springBootLoggingApplication.greeting("name");
        assertEquals(result, "Welcome name");
	}
	
	@Test
	public void invalidNameTest() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> new SpringBootLoggingApplication().greeting("exception"));
        assertEquals("Test exception raised.", exception.getMessage());
	}

}
