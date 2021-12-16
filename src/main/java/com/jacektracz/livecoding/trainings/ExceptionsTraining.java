package com.jacektracz.livecoding.trainings;

public class ExceptionsTraining {

	public int execTest(int[] params,int idx){
		
		try {
			return params[10];
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Out of bound:-->" + idx);
			ex.printStackTrace();
			System.out.println("Out of bound:<--" + idx);
			return 0;
		}		
	}
	
	public int execTestMain() {
		int[] par = new int[4];		
		return execTest(par,10);
	}
}
