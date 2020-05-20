package com.javasampleapproach.springsecurity.jdbcauthentication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityJdbcAuthenticationPostgreSqlApplicationTests {
  
	 
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        TestRestTemplate testRestTemplate
        = new TestRestTemplate("user", "user");
       ResponseEntity<String> response = testRestTemplate.
         getForEntity("http://localhost:8080/login", String.class);
         
       assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    public void givenAuthRequestOnPrivateServiceAdmin_shouldSuccedWith200() throws Exception {
        TestRestTemplate testRestTemplate
        = new TestRestTemplate("admin", "admin");
       ResponseEntity<String> response = testRestTemplate.
         getForEntity("http://localhost:8080/admin", String.class);
         
       assertEquals(HttpStatus.OK, response.getStatusCode());
    }
        
    @Test
    public void givenAuthRequestOnPrivateService_shouldFail() throws Exception {
        TestRestTemplate testRestTemplate
        = new TestRestTemplate("user", "user");
       ResponseEntity<String> response = testRestTemplate.
         getForEntity("http://localhost:8080/login", String.class);
       
       ResponseEntity<String> expected = testRestTemplate.
    	         getForEntity("http://localhost:8080/admin", String.class);    
       assertFalse(response.equals(expected));
    }
    
    

}
