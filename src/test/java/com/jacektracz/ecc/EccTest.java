package com.jacektracz.ecc;

import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.hamcrest.Matcher;
import org.junit.Test;

public class EccTest {

	//@Test	
	public void execEncryptECC_New() {
		ECCMain ecc = new ECCMain();
		ecc.execEEncyptionDecryptionWithCurve_New();;
	}
	
	@Test
	public void execEncryptECC_NIST_P_192() {
		ECCMain ecc = new ECCMain();
		ecc.execEEncyptionDecryptionWithCurve_NIST_P_192();
	}
	
		
}

