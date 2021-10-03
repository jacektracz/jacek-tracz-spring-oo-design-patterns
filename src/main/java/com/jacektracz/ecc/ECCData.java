package com.jacektracz.ecc;

import java.math.BigInteger;

public class ECCData {
	
    private BigInteger parA = BigInteger.valueOf(123);
    private BigInteger parB = BigInteger.valueOf(123);;
    private BigInteger parP = BigInteger.valueOf(123);
    private ECPoint genPoint;
    private KeyPair kp = null;
    private EllipticCurve ecc = null;
    
	public BigInteger getParA() {
		return parA;
	}
	
	public ECCData setParA(BigInteger parA) {
		this.parA = parA;
		return this;
	}
	
	public BigInteger getParB() {
		return parB;
	}
	
	public ECCData setParB(BigInteger parB) {
		this.parB = parB;
		return this;
	}
	
	public BigInteger getParP() {
		return parP;
	}
	
	public ECCData setParP(BigInteger parC) {
		this.parP = parC;
		return this;
	}
	
	public KeyPair getKp() {
		return kp;
	}
	
	public ECCData setKp(KeyPair kp) {
		this.kp = kp;
		return this;
	}

	public EllipticCurve getEcc() {
		return ecc;
	}

	public void setEcc(EllipticCurve ecc) {
		this.ecc = ecc;
	}

	public ECPoint getGenPoint() {
		return genPoint;
	}

	public ECCData setGenPoint(ECPoint genPoint) {
		this.genPoint = genPoint;
		return this;
	}

}
