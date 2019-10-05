package com.ahasan.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ahasan.bean.Book;

public class StreamMapTest {
	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book("ABC", 15),new Book("ABCD", 12),new Book("AB", 24));
	
		books.stream().map(Book::getName).map(String::length).collect(Collectors.toList()).forEach(System.out::println);
		
		books.stream().map(Book::getName).collect(Collectors.toList()).forEach(System.out::println);
	}
}
