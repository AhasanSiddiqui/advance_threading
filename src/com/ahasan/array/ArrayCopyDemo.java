package com.ahasan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ArrayCopyDemo {
	public static void main(String[] args) {
		String[] arr = { "A", "B", "C","D","E","F","G","H" };
		String[] clone = arr.clone();
		String[] copyOf = Arrays.copyOf(arr, arr.length);
		String[] copyOfStrings = Arrays.copyOfRange(arr, 2, 6);
		System.out.println("Original : " + Arrays.toString(arr));
		System.out.println("Clone : " + Arrays.toString(clone));
		System.out.println("Copy : " + Arrays.toString(copyOf));
		System.out.println("CopyOfRange : " + Arrays.toString(copyOfStrings));
		//1. String to String[]
		 
		String blogName = "how to do in java";
		@SuppressWarnings("unused")
		String[] words = null;
		 
		// Method 1 :: using String.split() method
		words = blogName.split(" ");                //[how, to, do, in, java]
		 
		// Method 2 :: using Pattern.split() method
		Pattern pattern = Pattern.compile(" ");
		words = pattern.split(blogName);            //[how, to, do, in, java]
		 
		//2. String[] to String
		 
		
		Iterator<Integer> digits = new ArrayList<>(Arrays.asList(1,2,3,4,5,6)).iterator();
		while (digits.hasNext()) {
			Integer integer = (Integer) digits.next();
			System.out.println(integer);
		}
	}
}
