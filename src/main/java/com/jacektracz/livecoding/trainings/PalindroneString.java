package com.jacektracz.livecoding.trainings;

public class PalindroneString {

	public static boolean checkPalindrone(String pstr) {
		boolean isPalin = false;
		String reverted = revertString(pstr);
		isPalin = pstr.equals(reverted);
		return isPalin;		
	}
	
	public static String revertString(String pstr) {
		String reverted = new String();
		byte[] pstrb = pstr.getBytes();
		byte[] pstrdest = pstr.getBytes();
		int ii = 0;
		for(byte b : pstrb) {
			pstrdest[pstrb.length - ii -1] = b;
			ii++;
		}
		reverted = new String(pstrdest);
		return reverted;
	}
}
