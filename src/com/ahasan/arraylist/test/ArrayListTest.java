package com.ahasan.arraylist.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("C");
		list.add("B");
		list.add(null);
		list.add("D");
		System.out.println(list.contains(null));

		List<String> strings = new ArrayList<String>(Arrays.asList("A", "B", "C", "E", "F", "A", "B"));
		/*
		 * Iterator<String> iterator = strings.iterator();
		 * System.out.println(iterator.next()); strings.add("G");
		 * System.out.println(iterator.next());
		 */
		System.out.println(strings.remove("A"));
		System.out.println(strings);

		System.out.println(new ArrayList<>(
				new LinkedHashSet<>(new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8)))));
		List<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

		List<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));

		List<String> combinedList = Stream.of(listOne, listTwo).flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(combinedList);
	}

}
