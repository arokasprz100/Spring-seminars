package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SimpleControllerTestMock {

    @Autowired
    private MockMvc mockMvc;

    //zamiast prawdziwego serwisu wstawiony zostaje automatycznie mock
    @MockBean
    private HelloService service; 

    @Test
    public void shouldReturnExpectedText() throws Exception {
        mockMvc
                .perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello!"));
    }



    @Test
    public void shouldReturnExpectedTextFromService() throws Exception {
       //gdy zostanie wywolana metoda getHello() to zwroc Mock
    	when(service.getHello()).thenReturn("Mock"); 

        mockMvc
                .perform(get("/helloworld"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Mock!")); 
    }
}