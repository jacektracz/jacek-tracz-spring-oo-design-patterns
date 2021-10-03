package com.jacektracz.java8.lambdasinaction.designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UmaryOperatorExample {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> result = math(list, x -> x * 2, x -> x + 1);

		System.out.println(result); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]

	}

	public static <T> List<T> math(List<T> list, UnaryOperator<T> uo, UnaryOperator<T> uo2) {
		List<T> result = new ArrayList<>();
		for (T t : list) {
			result.add(uo.andThen(uo2).apply(t));
		}
		return result;
	}

}
