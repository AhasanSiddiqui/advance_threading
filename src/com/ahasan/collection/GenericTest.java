package com.ahasan.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		List list=new ArrayList<String>(Arrays.asList("A","B","C"));
		list.add(1);
		System.out.println(list);
		m1(list).forEach(System.out::println);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static List m1(List list) {
		list.add(1);
		list.add(1.0);
		list.add('a');
		return list;
	}
}
