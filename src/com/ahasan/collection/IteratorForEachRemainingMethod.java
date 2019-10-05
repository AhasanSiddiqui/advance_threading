package com.ahasan.collection;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorForEachRemainingMethod {
	public static void main(String[] args) {
		Iterator<Integer> iterator = Arrays.asList(1, 4, 223, 56, 23, 88, 346, 78, 45, 33).iterator();
		while (iterator.hasNext()) {
			if (iterator.next() > 100) {
				break;
			}
		}
		iterator.forEachRemaining(System.out::println);
	}
}
