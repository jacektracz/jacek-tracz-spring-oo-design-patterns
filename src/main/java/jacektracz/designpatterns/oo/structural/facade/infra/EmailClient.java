package jacektracz.designpatterns.oo.structural.facade.infra;

import org.springframework.stereotype.Service;

import jacektracz.designpatterns.oo.structural.facade.entity.Customer;

// We pretend this is an external API we have to use
@Service
public class EmailClient {
	
	public void sendEmail(String from, String to, String subject, String message) {
		// implementation goes here
	}
}
