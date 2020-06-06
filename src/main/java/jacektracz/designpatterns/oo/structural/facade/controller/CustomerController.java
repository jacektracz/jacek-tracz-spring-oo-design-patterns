package jacektracz.designpatterns.oo.structural.facade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jacektracz.designpatterns.oo.structural.facade.facade.CustomerFacade;
import jacektracz.designpatterns.oo.structural.facade.facade.dto.CustomerDto;

@Controller //faking it
@RequiredArgsConstructor
public class CustomerController {
	
	// TO_DO_JT
    private CustomerFacade customerFacade;

    // @GetMapping
    public CustomerDto getById(long customerId) {
        return customerFacade.findById(customerId);
    }

    // @PostMapping
    public void register(CustomerDto customerDto) {
        customerFacade.registerCustomer(customerDto);
    }
}
