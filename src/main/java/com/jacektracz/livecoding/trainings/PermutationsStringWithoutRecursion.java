package com.jacektracz.livecoding.trainings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsStringWithoutRecursion {
	
	public static void permute(String s) {
	    if(null==s || s.isEmpty()) {
	        return;
	    }

	    // List containing words formed in each iteration 
	    List<String> strings = new LinkedList<String>();
	    strings.add(String.valueOf(s.charAt(0))); // add the first element to the list

	     // Temp list that holds the set of strings for 
	     //  appending the current character to all position in each word in the original list
	    List<String> tempList = new LinkedList<String>(); 

	    for(int i=1; i< s.length(); i++) {

	        for(int j=0; j<strings.size(); j++) {
	            tempList.addAll(merge(s.charAt(i), strings.get(j)));
	                        }
	        strings.removeAll(strings);
	        strings.addAll(tempList);

	        tempList.removeAll(tempList);

	    }

	    for(int i=0; i<strings.size(); i++) {
	        System.out.println(strings.get(i));
	    }
	}

	private static Set<String> merge(Character c,  String s) {
	    if(s==null || s.isEmpty()) {
	        return null;
	    }

	    int len = s.length();
	    StringBuilder sb = new StringBuilder();
	    Set<String> list = new HashSet<String>();

	    for(int i=0; i<= len; i++) {
	        sb = new StringBuilder();
	        sb.append(s.substring(0, i) + c + s.substring(i, len));
	        list.add(sb.toString());
	    }

	    return list;
	}

	
	/* ----------------------------------- */
	
	public static void permutationsExecute() {
	    // TODO Auto-generated method stub
	    String s="abc";
	    List<String>combinations=new ArrayList<String>();
	    combinations=permutations(s);
	    Collections.sort(combinations);
	    System.out.println(combinations);
	}
	
	private static List<String> permutations(String s) {
	    // TODO Auto-generated method stub
	    List<String>combinations=new ArrayList<String>();
	    if(s.length()==1){
	        combinations.add(s);
	    }
	    else{
	        for(int i=0;i<s.length();i++){
	            List<String>temp=permutations(s.substring(0, i)+s.substring(i+1));
	            for (String string : temp) {
	                combinations.add(s.charAt(i)+string);
	            }
	        }
	    }
	    return combinations;
	}
	

}
