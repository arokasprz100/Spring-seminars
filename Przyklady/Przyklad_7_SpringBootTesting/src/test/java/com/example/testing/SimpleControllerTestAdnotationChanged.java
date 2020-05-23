package com.example.testing;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest //testowanie calego kontekstu springa, nie tylko MVC
@AutoConfigureMockMvc  //zapewnia mozliwosc korzystania z MockMvc
public class SimpleControllerTestAdnotationChanged {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnExpectedText() throws Exception {
        mockMvc
                .perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello!"));
    }

    @Test
    public void shouldReturnExpectedTextFromService() throws Exception {
        mockMvc
                .perform(get("/helloworld"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!")); 
    }
}
