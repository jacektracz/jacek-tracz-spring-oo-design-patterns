package jacektracz.designpatterns.oo.structural.facade.facade;

import jacektracz.designpatterns.oo.structural.facade.Facade;
import jacektracz.designpatterns.oo.structural.facade.entity.Customer;
import jacektracz.designpatterns.oo.structural.facade.entity.Email;
import jacektracz.designpatterns.oo.structural.facade.facade.dto.CustomerDto;
import jacektracz.designpatterns.oo.structural.facade.infra.EmailClient;
import jacektracz.designpatterns.oo.structural.facade.repo.EmailRepository;
import lombok.RequiredArgsConstructor;

@Facade
@RequiredArgsConstructor
public class StockFacade {

	public void checkStock() {
		// 3 lines of domain Logic

		// TODO same as in CustomerFacade but with other subject/body
		
	}
}
