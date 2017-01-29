package spring.ex07.DI_componentscan;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
	public String getMessage() {
	    return "Hello spring";
    }
	
}
