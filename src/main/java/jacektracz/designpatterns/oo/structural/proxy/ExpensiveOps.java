package jacektracz.designpatterns.oo.structural.proxy;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import org.jooq.lambda.Unchecked;
import org.springframework.beans.factory.annotation.Autowired;

import jacektracz.designpatterns.oo.stuff.JtLogger;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class ExpensiveOps {
	
	@Autowired
	JtLogger log;
	
	private static final BigDecimal TWO = new BigDecimal("2");
	
	public Boolean isPrime(int n) { 
		log.debug("Computing isPrime({})" + n);
		BigDecimal number = new BigDecimal(n);
		if (number.compareTo(TWO) <= 0) {
			return true;
		}
		if (number.remainder(TWO).equals(BigDecimal.ZERO)) {
			return false;
		}
		for (BigDecimal divisor = new BigDecimal("3"); 
			divisor.compareTo(number.divide(TWO)) < 0;
			divisor = divisor.add(TWO)) {
			if (number.remainder(divisor).equals(BigDecimal.ZERO)) {
				return false;
			}
		}
		return true;
	}

	@SneakyThrows
	public String hashAllFiles(File folder) throws NoSuchAlgorithmException, IOException {
		log.debug("Computing hashAllFiles " + folder.toString());
		MessageDigest md = MessageDigest.getInstance("MD5");
		for (int i = 0; i < 3; i++) { // pretend there is much more work to do here
			Files.walk(folder.toPath())
				.map(Path::toFile)
				.filter(File::isFile)
				.map(Unchecked.function(FileUtils::readFileToString))
				.forEach(s -> md.update(s.getBytes()));
		}
		byte[] digest = md.digest();
	    return DatatypeConverter.printHexBinary(digest).toUpperCase();
	}
	
}
