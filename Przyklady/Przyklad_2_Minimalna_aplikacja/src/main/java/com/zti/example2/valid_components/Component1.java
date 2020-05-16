package com.zti.example2.valid_components;

import org.springframework.stereotype.Component;

@Component
public class Component1 {
	
	public Component1() {
		System.out.println("Component1 constructor");
	}
	
	public void print() {
		System.out.println("Component1 printing");
	}
}
