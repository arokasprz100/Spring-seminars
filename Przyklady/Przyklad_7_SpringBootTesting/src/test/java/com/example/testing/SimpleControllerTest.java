package com.example.testing;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)  // uruchamianie testu z uzyciem SpringRunnera
@WebMvcTest // zapewnia konfiguracje kontekstu springowego bez tworzenia serwera
public class SimpleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
//	wykonanie zapytania wykorzystujac mockMvc
//	sprawdza czy prawidlowo mapowany jest adres oraz czy serializacja danych dziala tak jak jest oczekiwane
    @Test
    public void shouldReturnExpectedText() throws Exception {
        mockMvc.perform(get("/hello"))
        .andExpect(status().isOk()).andExpect(content().string("Hello!"));
    }
	
}
