package com.ahasan.array;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;

public class TestArray {
	public static void main(String[] args) {
		String array1[]=new  String []{"A","B","C"};
		String array2[]=new  String []{"D","E","F"};
		String result[][]=new  String [][]{array1,array2};
		System.out.println(result);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.deepToString(result));
		Stream<Date> stream = Stream.generate(() -> { return new Date(); });
        stream.forEach(p -> System.out.println(p));
	}
}
