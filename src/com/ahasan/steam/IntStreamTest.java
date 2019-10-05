package com.ahasan.steam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class IntStreamTest {
	public static void main(String[] args) {
		int sum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToInt(Integer::intValue).sum();
		System.out.println("Intsum : " + sum);
		OptionalDouble average = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToInt(Integer::intValue).average();
		long longSum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToLong(x -> x).sum();
		System.out.println("longSum : " + longSum);

		double doubleSum = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).mapToDouble(x -> x).sum();
		System.out.println("DoubleSum : " + doubleSum);
		System.out.println("Average : " + average.getAsDouble());

		String[][] arr = { { "a", "b" }, { "c", "d" } };
		Stream.of(arr).filter(x -> "a".equals(x)).collect(Collectors.toSet()).forEach(System.out::println);

		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		System.out.println(Stream.of(intArray).flatMapToInt(x -> Arrays.stream(x)).sum());

		DoubleStream distinct = Stream.of(1, 2, 2, 4, 1, 7, 3, 4, 5, 6, 7, 8, 9, 10).mapToDouble(x -> x).distinct();
		distinct.forEach(System.out::println);

		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

		Map<String, Long> collect = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		collect.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		Map<String, Long> finalMap = new HashMap<String, Long>();
		collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(entry -> finalMap.put(entry.getKey(), entry.getValue()));

		finalMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("E", 5);
		map.put("F", 6);
		map.put("B", 2);
		map.put("A", 1);
		map.put("D", 4);
		map.put("C", 3);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		Map<String, Integer> sortedMap = new HashMap<String, Integer>();

		for (Entry<String, Integer> entry : entries) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		System.out.println(sortedMap);

		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 1; i < 51; i++) {
			integers.add(i);
		}

		integers.stream().filter(a -> a%3==0).filter(a -> a % 5 == 0).filter(a -> a % 15 == 0)
				.collect(Collectors.toList()).forEach(a -> System.out.println(a));
	}
}
