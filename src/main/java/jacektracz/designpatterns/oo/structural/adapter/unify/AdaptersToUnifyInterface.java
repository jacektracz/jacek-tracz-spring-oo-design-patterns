package jacektracz.designpatterns.oo.structural.adapter.unify;

import org.springframework.beans.factory.annotation.Autowired;

import jacektracz.designpatterns.oo.stuff.JtLogger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdaptersToUnifyInterface {
	
	@Autowired
	JtLogger log;
	
    void emitInsurance(Person p) {
        if (p.getSsn() != null) {
            audit("Person by SSN " +  p.getSsn());
        } else {
            audit("Person by Birth Certificate# " +  p.getBirthCertificateNo());
        }
    }
    void emitInsurance(Vessel v) {
        audit("Vessel IMO " + v);
    }

    private void audit(String message) {
        log.debug("Storing audit ''" + message);
    }
}



class Person{
    private Long ssn;
    private String birthCertificateNo;

    public String getBirthCertificateNo() {
        return birthCertificateNo;
    }

    public Long getSsn() {
        return ssn;
    }
}
class Vessel {
    private String imo;

    public String getImo() {
        return imo;
    }
}