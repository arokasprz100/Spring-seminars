package com.zti.example3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Obejrzec jak wyglada implementacja
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

// @SpringBootApplication
@Configuration
// @ComponentScan
@EnableAutoConfiguration
public class Example3Application {
	

	private static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Example3Application.class, args);
		
		listAllBeans();
		System.out.println();
		checkBeansPresence("component1", "component2", "component3");
	}
	
	private static void listAllBeans() {
		System.out.println("Beans managed by Spring app context:");
		for (String beanName : applicationContext.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}
	
	// Zrodlo: https://www.baeldung.com/spring-component-scanning
	private static void checkBeansPresence(String... beans) {
        for (String beanName : beans) {
            System.out.println("Is " + beanName + " in ApplicationContext: " + 
              applicationContext.containsBean(beanName));
        }
    }

}
