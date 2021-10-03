package com.jacektracz.trainings.stream;

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



public class StreamsTrainingTest {

	@Test
	public void execCreate() {
		StreamsTraining training = new StreamsTraining();
		training.execCreate();
	}
	
	@Test
	public void execFilter() {
		StreamsTraining training = new StreamsTraining();
		training.execFilter();
	}
	
	@Test
	public void execGroups() {
		StreamsTraining training = new StreamsTraining();
		training.execGroups();
	}
	
	@Test
	public void execUnwrap() {
		StreamsTraining training = new StreamsTraining();
		training.execUnwrap();
	}
		
}

