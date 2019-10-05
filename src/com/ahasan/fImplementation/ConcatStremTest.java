package com.ahasan.fImplementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ahasan.bean.Book;

public class ConcatStremTest {
	public static void main(String[] args) {
		integersRemoveDuplicate().forEach(System.out::println);
		listRemoveDuplicate();
	}

	private static List<Book> listRemoveDuplicate() {
		return null;
		// TODO Auto-generated method stub
		
	}

	private static List<Integer> integersRemoveDuplicate() {
		return Stream.concat(Arrays.asList(1, 2, 3, 4, 5).stream(), Arrays.asList(4, 5, 6, 7, 8).stream()).distinct()
				.collect(Collectors.toList());
	}
}
