package jacektracz.designpatterns.oo.structural.facade.repo;

import org.springframework.stereotype.Repository;

import jacektracz.designpatterns.oo.structural.facade.entity.Email;

@Repository
public class EmailRepository {

	public boolean emailWasSentBefore(int emailHash) {
		return false; // TODO fake implementation
	}

	public void saveSentEmail(Email email) {
		 // TODO
	}

}
