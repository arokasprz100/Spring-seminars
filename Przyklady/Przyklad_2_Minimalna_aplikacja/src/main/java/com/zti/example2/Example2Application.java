package com.zti.example2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// zaznaczyć -> prawy przycisk myszy -> Open Declaration
@SpringBootApplication
public class Example2Application {

	public static void main(String[] args) {
		System.out.println("Before run");
		SpringApplication.run(Example2Application.class, args);
		System.out.println("After run");
	}

}
