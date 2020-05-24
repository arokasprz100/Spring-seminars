package com.javainuse;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;



public class TestHelloController {

	@Test
    public void testHomeController() {
        HelloController helloController = new HelloController();
        String result = helloController.index();
        assertEquals(result, "Greetings from Spring Boot with Spring Security!");
    }
}