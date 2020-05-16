package com.zti.example2.valid_components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Component2 {
	
	private Component1 component1;
	
	@Autowired
	public void setComponent1(Component1 component1) {
		this.component1 = component1;
		this.component1.print();
	}
	
	public Component2() {
		System.out.println("Component2 constructor");
	}
}
