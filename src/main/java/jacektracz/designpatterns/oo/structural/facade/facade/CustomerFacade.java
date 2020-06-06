package jacektracz.designpatterns.oo.structural.facade.facade;

import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import jacektracz.designpatterns.oo.structural.facade.Facade;
import jacektracz.designpatterns.oo.structural.facade.entity.Customer;
import jacektracz.designpatterns.oo.structural.facade.entity.Email;
import jacektracz.designpatterns.oo.structural.facade.facade.dto.CustomerDto;
import jacektracz.designpatterns.oo.structural.facade.infra.EmailClient;
import jacektracz.designpatterns.oo.structural.facade.repo.CustomerRepository;
import jacektracz.designpatterns.oo.structural.facade.repo.EmailRepository;
import jacektracz.designpatterns.oo.structural.facade.repo.SiteRepository;

@Facade
@RequiredArgsConstructor
public class CustomerFacade {
	
	@Autowired
	private  CustomerRepository customerRepo;
	
	@Autowired
	private  EmailClient emailClient;
	
	@Autowired
	private  EmailRepository emailRepo;
	
	@Autowired
	private  SiteRepository siteRepo;
	
	/*
	public CustomerFacade(){
		customerRepo = new CustomerRepository();
		emailClient = new EmailClient();
		emailRepo = new EmailRepository();
		siteRepo = new SiteRepository();
	}
	*/
	public CustomerDto findById(long customerId) {
		Customer customer = customerRepo.findById(customerId);
		CustomerDto dto = new CustomerDto();
		dto.name = customer.getName();
		dto.email = customer.getEmail();
		dto.creationDateStr = new SimpleDateFormat("yyyy-MM-dd").format(customer.getCreationDate());
		dto.id = customer.getId();
		return dto;
	}

	public void registerCustomer(CustomerDto dto) {
		Customer customer = new Customer();
		customer.setEmail(dto.email);
		customer.setName(dto.name);
		customer.setSite(siteRepo.getReference(dto.countryId));

		if (customer.getName().trim().length() <= 5) {
			throw new IllegalArgumentException("Name too short");
		}
		
		if (customerRepo.customerExistsWithEmail(customer.getEmail())) {
			throw new IllegalArgumentException("Email already registered");
		}
		// Heavy logic
		// Heavy logic
		customerRepo.save(customer);
		// Heavy logic

		sendRegistrationEmail(customer.getEmail());
	}

	private void sendRegistrationEmail(String emailAddress) {
		System.out.println("Sending activation link via email to "+ emailAddress);
		Email email = new Email();
		email.setFrom("noreply");
		email.setTo(emailAddress);
		email.setSubject("Welcome!");
		email.setBody("You'll like it! Sincerely, Team");
		
		if (!emailRepo.emailWasSentBefore(email.hashCode())) {
			emailClient.sendEmail(email.getFrom(), email.getTo(), email.getSubject(), email.getBody());
			emailRepo.saveSentEmail(email);
		}
	}
}
