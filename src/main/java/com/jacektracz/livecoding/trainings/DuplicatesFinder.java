package com.jacektracz.livecoding.trainings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicatesFinder {
	  // Convert list to set, and if list has duplicates -> show duplicate count
	  public static void findDuplicates(List<String> names) {
	    
	    
	    
	    Set<String> namesSet = new HashSet(names);
	    // names.size() != namesSet.size();// => true if duplicates
	    boolean hasDuplicates = names.size() != namesSet.size();
	    
	    Function<String, String> action = getFunction(names, hasDuplicates);
	    Function<String, String> action2 = s -> "one";
	    names.stream()
	         .map(action)
	         .collect(Collectors.toSet())
	         .forEach(System.out::println);

	    names.stream()
        .map(action2)
        .collect(Collectors.toSet())
        .forEach(System.out::println);
	    
	  }  
	  
	  static Function<String, String> getFunction(List<String> names, boolean hasDuplicates){
	    // Collections.frequency(names, name) => to get duplicate count	     
	    if(  hasDuplicates ) {  
	          return par -> par +" ("+Collections.frequency(names, par)+")";
	    }
	    return t -> t;
	  }
	}