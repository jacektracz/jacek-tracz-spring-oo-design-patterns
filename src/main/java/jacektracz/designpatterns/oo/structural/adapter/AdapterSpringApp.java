package jacektracz.designpatterns.oo.structural.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jacektracz.designpatterns.oo.structural.adapter.domain.UserService;
import jacektracz.designpatterns.oo.stuff.JtLogger;

@Slf4j
@SpringBootApplication
public class AdapterSpringApp implements CommandLineRunner {
	@Autowired
	JtLogger log;
	
	public static void main(String[] args) {
		SpringApplication.run(AdapterSpringApp.class, args);
	}

	@Autowired
	private UserService userService;
	
	public void run(String... args) throws Exception {
		userService.importUserFromLdap("jdoe");
		log.debug("Found users: " + userService.searchUserInLdap("doe"));
	}
}