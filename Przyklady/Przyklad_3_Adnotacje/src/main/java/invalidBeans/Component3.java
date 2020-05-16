package invalidBeans;

import org.springframework.stereotype.Component;

@Component
public class Component3 {
	
	public Component3() {
		System.out.println("Creating Component3 instance");
	}
}
