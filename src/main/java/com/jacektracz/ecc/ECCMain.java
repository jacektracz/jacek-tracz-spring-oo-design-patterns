package com.jacektracz.ecc;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;
import java.util.function.Supplier;

public class ECCMain {

	
	public static void encrypt() {

		String plainText = "New text to encryp";
		
		PublicKey publicKey = new PublicKey(
				EllipticCurve.NIST_P_192.NIST_P_192,
				EllipticCurve.NIST_P_192.getBasePoint());
		
        byte[] byteFile = null;
		try {
			
			byteFile = ECC.encrypt(
					plainText.getBytes("utf-8"),
					publicKey);
			
        }
        catch (Exception ex){
        	handleException( ex );
        	
        }
        String text = new BigInteger(byteFile).toString(16);
		
	}
	
	public static void decrypt(String cipherText) {
		String privateKeyFile = "";
        PrivateKey privateKey = new PrivateKey(privateKeyFile);
        
        try {
			byte[] byteFile = ECC.decrypt(
					cipherText.getBytes("utf-8"), 
					privateKey);
        }
        catch (Exception ex){
        	handleException( ex );
        	
        }
	}
	
	public static String encryptWithPublicKey(PublicKey publicKey,String plainText) {

		String method = "::encryptWithPublicKey::";
				
        byte[] byteFile = null;
		try {
			printText(method + "plain-text:" + plainText);
			
			byteFile = ECC.encrypt(
					plainText.getBytes("utf-8"),
					publicKey);
			
			String encryptedText = new BigInteger(byteFile).toString(16);
			printText(method + "encrypted-text:" + encryptedText);
			return encryptedText;
        }
        catch (Exception ex){
        	handleException( ex );
        	return "";
        }		
	}
	
	public static String decryptWithPrivateKey(PrivateKey privateKey,String cipherText) {
        String method = "::decryptWithPrivateKey::";
        try {
        	printText(method + "cipher-text:" + cipherText);
			byte[] byteFile = ECC.decrypt(
					getByteArray(cipherText), 
					privateKey);
			String decryptedText = new String(byteFile);
			printText(method + "decrypted-text:" + decryptedText);
			return decryptedText;
					
        }        
        catch (Exception ex){
        	handleException( ex );
        	return null;
        }
        
	}
	
	public void execEEncyptionDecryptionWithCurve_New() {
		try {
			 String txtToEncrypt = "New plain text";
			 Supplier<ECCData> eccprovider = ECCMain::generateKeyForNewCurve;
			 execEEncyptionDecryption(eccprovider,txtToEncrypt);
		}catch (Exception ex){
			handleException( ex );        	
		}		 
		 
	}
	
	public void execEEncyptionDecryptionWithCurve_NIST_P_192() {
		try {
			String method = "::execEEncyptionDecryptionWithCurve_NIST_P_192::";
			printText(method + "start");
			String txtToEncrypt = "New plain text";
		 	Supplier<ECCData> eccprovider = ECCMain::generateKeyForCurve_NIST_P_192;
		 	execEEncyptionDecryption(eccprovider,txtToEncrypt);
		}catch (Exception ex){
			handleException( ex );        	
		}		 
	}
	
	// generateKeyForCurve_NIST_P_192
	public void execEEncyptionDecryption(Supplier<ECCData> eccdata, String txtToEncrypt) {
		String method = "::execEEncyptionDecryption::";
		try {
			printText(method + "[txtToEncrypt:" + txtToEncrypt + "]");
		 	ECCData data = eccdata.get();
		 	String encryptedText = encryptWithPublicKey(
				 data.getKp().getPublicKey()
				 ,txtToEncrypt);
		 	
		 	printText(method + "[encryptedText:" + encryptedText + "]");
		 	
		 	String decryptedText = decryptWithPrivateKey(
				 data.getKp().getPrivateKey()
				 ,encryptedText);
		 	
		 	printText(method + "[decryptedText:" + decryptedText + "]");
		 	
		 	
		}catch (Exception ex){
			handleException( ex );        	
		}		 
	}
	
	public static ECCData generateKeyForNewCurve() {
		ECCData data = new ECCData()
	        .setParA(BigInteger.valueOf(2))
	        .setParB(BigInteger.valueOf(3))
	        .setParP(BigInteger.valueOf(5));
		
		EllipticCurve ecc = new EllipticCurve(
				data.getParA(),
				data.getParB(),
				data.getParP());
		
		data.setEcc(ecc);
		
		printECCData(data);
		
        KeyPair kp = null;
        try {
            kp = ECC.generateKeyPair(
            		data.getEcc(), 
            		new Random(System.currentTimeMillis()));            
        }
        catch (Exception ex){
        	handleException( ex );        	
        }
        data.setKp(kp);
        return data;       
	}

	public static ECCData generateKeyForCurve_NIST_P_192() {
		//EllipticCurve eccNis = EllipticCurve.NIST_P_192;
		//EllipticCurve eccNis = EllipticCurve.NIST_P_224;
		//EllipticCurve eccNis = EllipticCurve.NIST_P_256;
		EllipticCurve eccNis = EllipticCurve.NIST_P_521;
		ECCData data = new ECCData()
	        .setParA(eccNis.getA())
	        .setParB(eccNis.getB())
	        .setParP(eccNis.getP())
	        .setGenPoint(eccNis.getGenPoint());
		
		EllipticCurve ecc = new EllipticCurve(
				eccNis.getA(),
				eccNis.getB(),
				eccNis.getP(),
				eccNis.getBasePoint());
		
		data.setEcc(ecc);
		
		printECCData(data);
		
        KeyPair kp = null;
        try {
            kp = ECC.generateKeyPair(
            		data.getEcc(), 
            		new Random(System.currentTimeMillis()));            
        }
        catch (Exception ex){
        	handleException( ex );        	
        }
        data.setKp(kp);
        return data;       
	}
	
	public static byte[] getByteArray(String txt) {
		try {
			return txt.getBytes("utf-8");
		} catch (Exception ex) {
			handleException( ex );
			return null;
		}
	}
	
	private static void handleException(Exception e) {
		e.printStackTrace();
	}
	
	public static void printText(String txt) {
		System.out.println(txt);
		
	}
	
	public static void printECCData(ECCData dt) {

		printText("ECC a:" + dt.getEcc().getA());
		printText("ECC b:" + dt.getEcc().getB());
		printText("ECC p:" + dt.getEcc().getP());
		
		if(dt.getEcc().getBasePoint()!= null) {
			printText("ECC base x:" + dt.getEcc().getBasePoint().x.toString());
			printText("ECC base y:" + dt.getEcc().getBasePoint().y.toString());
		}
		if (dt.getKp() != null 
				&& dt.getKp().getPrivateKey() != null 
				&& dt.getKp().getPrivateKey().getBasePoint() != null){ 
			printText("Private Base point x:" + dt.getKp().getPrivateKey().getBasePoint().x.toString());
			printText("Private Base point y:" + dt.getKp().getPrivateKey().getBasePoint().y.toString());
		}
		if (dt.getKp() != null 
				&& dt.getKp().getPrivateKey() != null 
				&& dt.getKp().getPrivateKey().getKey() != null){ 
			printText("Private key lowestSetBit :" + dt.getKp().getPrivateKey().getKey().getLowestSetBit());
		}
		if (dt.getKp() != null 
				&& dt.getKp().getPublicKey() != null 
				&& dt.getKp().getPublicKey().getBasePoint() != null){ 		
			printText("Public Base point x:" + dt.getKp().getPublicKey().getBasePoint().x.toString());
			printText("Public Base point y:" + dt.getKp().getPublicKey().getBasePoint().y.toString());
		}
		if (dt.getKp() != null 
				&& dt.getKp().getPublicKey() != null 
				&& dt.getKp().getPublicKey().getKey() != null){ 		
		
			printText("Public key x :" + dt.getKp().getPublicKey().getKey().x.toString());
			printText("Public key y :" + dt.getKp().getPublicKey().getKey().x.toString());
		}	
		if(dt.getParA() != null) {
			printText("Par A:" + dt.getParA().toString());
		}
		if(dt.getParB() != null) {
			printText("Par B:" + dt.getParB().toString());
		}
		if(dt.getParP() != null) {
			printText("Par C:" + dt.getParP().toString());
		}
	}
	
}
