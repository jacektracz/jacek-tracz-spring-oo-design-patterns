package com.jacektracz.trainings.stream;

import java.util.function.Predicate;

public class SearchItemEntry {

	public String name;
	public int age;
	
	public SearchItemEntry() {
		name = "a1";
		age = 22;
	}
	
	public SearchItemEntry(String name, int age) {
		this.name = name;
		this.age = age;
	
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return "SerchItremEntry{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

	public boolean filterAge() {
		return this.getAge() > 10;
	}
}